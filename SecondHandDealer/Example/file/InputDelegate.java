package file;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import vehicles.*;


public class InputDelegate {
	ArrayList <Vehicle> vehicleList = new ArrayList<Vehicle>();

	
	public void read(String fileName){
		
		int counter = 0;
		double num = 0;
		WriteFile wf = new WriteFile();
		wf.openWFile("output.txt");
		
		FileRead fr= new FileRead();
		Scanner input=null;
		input =fr.openFile(fileName);
		String token;
		
		DecimalFormat d = new DecimalFormat("0.00");
		Truck truck=new Truck();
		ElectricCar ecar=new ElectricCar();
		PetrolCar pcar=new PetrolCar();
		Bus bus=new Bus();
		
		
		
		while (input.hasNext()){
			
			String line=input.nextLine();
			StringTokenizer st=new StringTokenizer(line);
			while (st.hasMoreTokens()){
				token=st.nextToken();
				if (token.equals("Petrol")){
					token = "Petrol Car";
					pcar.type = token;
					pcar.age = st.nextToken();
					pcar.model = st.nextToken();
					pcar.price = st.nextToken();
					pcar.doornumber=st.nextToken();
					pcar.setFcapacity(st.nextToken());
					vehicleList.add(pcar);
					counter++;
				}
				else if (token.equals("Electric")){
					token = "Electric Car";
					ecar.type = token;
					ecar.age = st.nextToken();
					ecar.model = st.nextToken();
					ecar.price = st.nextToken();
					ecar.doornumber=st.nextToken();
					ecar.setBcapacity(st.nextToken());
					vehicleList.add(ecar);
					counter++;
				}
				else if (token.equals("Bus")){
					bus.type = token;	
					bus.age = st.nextToken();
					bus.model = st.nextToken();
					bus.price = st.nextToken();
					bus.taxrate=st.nextToken();
					bus.capacity=st.nextToken();
					vehicleList.add(bus);
					counter++;
				}
				else if (token.equals("Truck")){
					truck.type = token;	
					truck.age = st.nextToken();
					truck.model = st.nextToken();
					truck.price = st.nextToken();
					truck.taxrate=st.nextToken();
					truck.tonnage=st.nextToken();
					vehicleList.add(truck);
					counter++;
				}
				else if (token.equals("print")){
										
					
					if(counter != 0) {
						wf.write("Number of cars sold: " + counter + "\n");
						String message;					
						for (int i = 0; i < vehicleList.size(); i++) {
							String price = vehicleList.get(i).price;
							num = Double.parseDouble(price);
							
							message = "\nType : " + vehicleList.get(i).type + "\n";
							message += "Model : " + vehicleList.get(i).model + "\n";
							message += "Age : " + vehicleList.get(i).age + "\n";
							
							String type = vehicleList.get(i).type;
							if (type.equals("Petrol Car")){
								message += "Fuel Capacity : " + ((PetrolCar)vehicleList.get(i)).getFcapacity()+ "\n";
								message += "Number of Doors : " + ((PetrolCar)vehicleList.get(i)).doornumber + "\n";
							}
							else if (type.equals("Electric Car")){
								message += "Battery Capacity : " + ((ElectricCar)vehicleList.get(i)).getBcapacity()+ "\n";
								message += "Number of Doors : " + ((ElectricCar)vehicleList.get(i)).doornumber + "\n";
							}
							else if (type.equals("Bus")){
								message += "Capacity : " + ((Bus)vehicleList.get(i)).capacity+ "\n";
							}
							else if (type.equals("Truck")){
								message += "Tonnage : " + ((Truck)vehicleList.get(i)).tonnage+ "\n";
							}
							message += "Price : " + d.format(num) + "\n";
							message += "\n";
							num += num; 
							wf.write(message);
							
							
						}
						
						String message2 = "Total Amount of Money : " + d.format(num) + "\n";
						wf.write("\n");
						wf.write(message2);	
					}
					else{
						wf.write("\nNumber of Cars Sold: 0 \nNo Vehicle that is sold \nTotal Amount of Money : 0.00 \n");
					}
					vehicleList.removeAll(vehicleList);
					counter = 0;
				}
			}
		}
		wf.closeWFile();
		fr.closeFile(input);
	}
}
