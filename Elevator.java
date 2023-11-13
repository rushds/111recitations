public class Elevator {

    private int maxNumFloors;
    private int maxWeight;
    private int currentFloor;
    private int currentWeight;
  
    public Elevator(int maxNumFloors, int maxWeight) {
      this.maxNumFloors = maxNumFloors;
      this.maxWeight = maxWeight;
      this.currentFloor = 1;
      this.currentWeight = 0;
    }

    public boolean goUpOneFloor(){
      if(currentFloor+1>maxNumFloors){
        System.out.println("Error: cant go past the max number of floors: " + maxNumFloors);
        return false;
      } 
      else {
        this.currentFloor+=1;
        return true;
      }
    }

    public boolean goDownOneFloor(){
        if(currentFloor-1<1){
          System.out.println("Error: cant go below floor 1");
          return false;
        } 
        else {
          this.currentFloor-=1;
          return true;
        }
    }
    public boolean addPassenger(int passengerWeight){
        if (passengerWeight<=0){
          System.out.println("Error: passenger must have positive weight");
          return false;
        }
        if(currentWeight+passengerWeight>maxWeight){
          System.out.println("Error: you have surpassed max weight, cannot add passenger");
          return false;
        } 
        else {
          currentWeight+=passengerWeight;
          return true;
        }
    }
    public boolean removePassenger(int passengerWeight){
        if (passengerWeight<=0){
          System.out.println("Error: passenger must have positive weight");
          return false;
        }
        if(currentWeight-passengerWeight<0){
          System.out.println("Error: you are trying to remove a passenger from an empty elevator");
          return false;
        } 
        else {
          currentWeight-=passengerWeight;
          return true;
        }
    }

    public int getCurrentWeight(){
        return currentWeight;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }    
    public static void main(String [] args){
        //feel free to test the class here!
        Elevator ele1 = new Elevator(7, 1000);
        System.out.println("Current floor: " + ele1.getCurrentFloor());
        System.out.println("Current weight: " + ele1.getCurrentWeight());
        ele1.addPassenger(135);
        System.out.println("Current weight: " + ele1.getCurrentWeight());
        
        //in hindsight, a getMaxFloor method might've been nice...
        //can you implement it?
        for(int i = 0; i < 6; i++){
            ele1.goUpOneFloor();
            System.out.println("Current floor: " + ele1.getCurrentFloor());
        }

        ele1.addPassenger(50000);//too heavy :()

    }
}
  
  
  