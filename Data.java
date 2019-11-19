public class Data{
  double arrivalTime;
  double departureTime;
  public Data(){
    arrivalTime = 0;
    departureTime = 0;
  }
  public void setArrivalTime(double a){
    arrivalTime = a;    //sets arrival time
  }
  public void setDepartureTime(double d){
    departureTime = d;  //sets departure time
  }
  public double getDepartureTime(){
    return departureTime;   //returns departure time for getting and setting
  }
  public double getArrivalTime(){
    return arrivalTime;    //returns departure time for getting and setting
  }
}