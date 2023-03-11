public class NBody {
    public static double readRadius(String FileName){
        In in = new In(FileName);
        in.readInt();
        double radius=in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String FileName){
        In in = new In(FileName);
        int n=in.readInt(); in.readDouble();
        Body[] b=new Body[n];
        int cnt=0;
        while(!in.isEmpty()){
            double xP,yP,xV,yV,m;
            String img;
            try{
                xP=in.readDouble();
            }
            catch(Exception e){
                return b;
            }
            yP=in.readDouble();
            xV=in.readDouble();
            yV=in.readDouble();
            m=in.readDouble();
            img=in.readString();
            b[cnt]=new Body(xP,yP,xV,yV,m,img);
            cnt++;
        }
        return b;
    }

    public static void main(String[] args){
        double T=Double.valueOf(args[0]),dt=Double.valueOf(args[1]);
        double t=0;
        String filename = args[2];
        double radius=readRadius(filename);
        Body[] b=readBodies(filename);
        int n=b.length;
        
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        
        while(t<T){
            double[] xForces=new double[n],yForces=new double[n];
            for(int i=0;i<n;i++){
                xForces[i]=b[i].calcNetForceExertedByX(b);
                yForces[i]=b[i].calcNetForceExertedByY(b);
                b[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Body e:b)
                e.draw();
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }

        
        
		StdDraw.pause(2000);
    }
}
