package algoritms.p;

public class MinDistance {

    public static double calculateMinDistanceBetweenTwoPoints(Point p1,Point p2) {
        return Math.abs(Math.sqrt( Math.pow(p2.getX()-p1.getX(),2) + Math.pow(p2.getY()-p1.getX(),2)));
    }

}
