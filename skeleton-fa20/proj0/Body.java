
public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    public Body(double xP, double yP, double xV,
              double yV, double m, String img){
                xxPos=xP;
                yyPos=yP;
                xxVel=xV;
                yyVel=yV;
                mass=m;
                imgFileName=img;
              }
    public Body(Body b){
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;
    }

    public double calcDistance(Body b){
        return Math.sqrt((xxPos-b.xxPos)*(xxPos-b.xxPos)+(yyPos-b.yyPos)*(yyPos-b.yyPos));
    }

    public double calcForceExertedBy(Body b){
        if(this.equals(b))
            return 0;
        return 6.67e-11*mass*b.mass/(calcDistance(b)*calcDistance(b));
    }

    public double calcForceExertedByX(Body b){
        if(this.equals(b))
            return 0;
        return calcForceExertedBy(b)/calcDistance(b)*(b.xxPos-xxPos);
    }
    public double calcForceExertedByY(Body b){
        if(this.equals(b))
            return 0;
        return calcForceExertedBy(b)/calcDistance(b)*(b.yyPos-yyPos);
    }

    public double calcNetForceExertedByX(Body[] b){
        double ans=0;
        for(Body e:b){
            ans+=calcForceExertedByX(e);
        }
        return ans;
    }
    public double calcNetForceExertedByY(Body[] b){
        double ans=0;
        for(Body e:b){
            ans+=calcForceExertedByY(e);
        }
        return ans;     
    }

    public void update(double t,double Fx,double Fy){
        double ax=Fx/mass,ay=Fy/mass;
        xxVel+=ax*t; yyVel+=ay*t;

        xxPos+=t*xxVel; yyPos+=t*yyVel;
    }

    public void print(){
        System.out.println(xxPos+" "+yyPos+" "+xxVel+" "+yyVel+" "+mass+" "+imgFileName);
    }

    public void draw(){
        String filename = "images/"+imgFileName;
        StdDraw.picture(xxPos,yyPos,filename);
    }

}
