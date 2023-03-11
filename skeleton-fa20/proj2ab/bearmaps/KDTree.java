package bearmaps;

import java.util.List;

public class KDTree implements PointSet{

    Node root;

    public class Node{
        double x,y;
        Node left,right;
        boolean vertical;

        public Node(int x,int y,boolean vertical){
            this.x=x;
            this.y=y;
            this.vertical=vertical;
            left=right=null;
        }
        public Node(Point p,boolean vertical){
            x=p.getX();
            y=p.getY();
            this.vertical=vertical;
            left=right=null;
        }
    }



    public KDTree(List<Point> points){
        root=new Node(points.get(0),false);
        for(int i=1;i<points.size();i++){
            add(root,points.get(i),root.vertical);
        }
    }

    public Node add(Node x,Point p,boolean v){
        if(x==null){
            return new Node(p,v);
        }
        if(v){
            if(p.getX()<x.x){
                x.left=add(x.left,p,!v);
            }
            else{
                x.right=add(x.right,p,!v);
            }
        }
        else{
            if(p.getY()<x.y){
                x.left=add(x.left,p,!v);
            }
            else{
                x.right=add(x.right,p,!v);
            }
        }
        return x;
    }

    public Point nearest(double x,double y){
        Point goal = new Point(x,y);
        Node ans = nearest(root,goal,root);
        return new Point(ans.x,ans.y);
    }

    private Node nearest(Node x,Point goal,Node best){
        if(x==null)
            return best;    
        if(Point.distance(new Point(x.x,x.y),goal)<Point.distance(new Point(best.x,best.y),goal)){
            best=x;
        }

        Node goodSide,badSide;
        if(x.vertical){
            if(goal.getX()<x.x){
                goodSide = x.left;
                badSide=x.right;
            }
            else{
                goodSide = x.right;
                badSide = x.left;
            }   
        }
        else{
            if(goal.getY()<x.y){
                goodSide=x.left;
                badSide=x.right;
            }
            else{
                goodSide=x.right;
                badSide=x.left;
            }
        }

        best=nearest(goodSide,goal,best);

    }
}
