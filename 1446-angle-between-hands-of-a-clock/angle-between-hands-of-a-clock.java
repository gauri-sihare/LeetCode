class Solution {
    public double angleClock(int hour, int minutes) {
        hour = hour%12;

    // 1 hr= 360/12 = 30degree 
    // 1 minHr = 30/60  => 0.5 deg
        double hour_angle = hour * 30 + minutes*0.5;
    // 1min = 360/60 = 6 deg
        double min_angle = minutes * 6;
        
        double tot_angle =  Math.abs(hour_angle - min_angle);

        return Math.min(tot_angle , 360-tot_angle);
    }
}