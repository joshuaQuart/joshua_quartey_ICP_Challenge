import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
* The program allows users to enter inventory details for a shop and saves the
* information to a text file and then creates a backup of the text file. .
*
*@author    Joshua Quartey, Paa Kwesi Kodua
*@version   1.0
*@since     2020-01-21
*/



public class InventoryManager{
  public ArrayList<Product> productStock;

  //Inner class to represent the items in inventory
  public class Product{
    private String id;
    private String name;
    private int quantity;
    private float price;

    //Default Constructor
    public Product(){
      id = null;
      name = null;
      quantity= 0;
      price = 0;
    }
    //Constructor
    public Product(String i, String n, int q,float p ){
      id = i;
      name = n;
      quantity= q;
      price = p;
    }
    //Accessor methods
    public String getId(){ return id;}
    public String getName(){ return name; }
    public int getQuantity(){ return quantity; }
    public float getPrice(){ return price; }

    //Mutator methods
    public void setId(String w){  id = w;}
    public void setName(String x){name = x;}
    public void setQuantity(int y){ quantity = y;}
    public void setPrice(float z){ price = z; }

  }
  //Constructor for InventoryManager class
  public InventoryManager(){
    productStock = new ArrayList<Product>();
  }
  //Method that initiates inventory taking process
  public void takeInventory(){
    String a="";
    String b="";
    float c=0;
    int d=0;
    int t=1;

		System.out.println("Inventory Management system ");
    System.out.println("--------------------------- ");
    System.out.println();

    System.out.println("How many entries are being made?");
    Scanner in2 = new Scanner(System.in);
    int k = in2.nextInt();
    in2.reset();
    System.out.println();

    System.out.println("Beginning entry... ");
    System.out.println();

    for(int qount=0;qount<k;qount++){
      System.out.println("Enter product ID: ");
      a= in2.next();

      System.out.println("Enter product name: ");
      b= in2.next();

      System.out.println("Enter product Price: ");
      c= in2.nextFloat();

      System.out.println("Enter quantity available: ");
      d= in2.nextInt();

      System.out.println("Moving to the next item");
      System.out.println();

      productStock.add(new Product(a,b,d,c));
      in2.reset();

    }

    System.out.println("Data entry complete.");
    System.out.println("Saving data to essentials_stock.txt .... ");

    // The code below writes the inventory data to the essentials_stock.txt
    // text file in a formatted form
    PrintWriter printWriter = null;
    try {
      printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
    }catch(FileNotFoundException f) {
      f.getMessage();
    }
    printWriter.printf("%-11s\t %-12s\t %-5s\t %-5s\n","Product ID","Product Name","Product Price","Quantity");
    printWriter.println();
    for (Product p1: productStock){
      printWriter.printf("%-3s %-8s\t %-12s\t %-5.2f\t\t %-5d\n",t+")",p1.getId(),p1.getName(),p1.getPrice(),p1.getQuantity());
      t++;
    }
    printWriter.close();

    System.out.println("File saved .... ");
    System.out.println();

    // The code below creates the backup file backup_essentials_stock.txt
    System.out.println("Creating backup_essentials_stock.txt .... ");

    try {
      FileReader or = new FileReader("essentials_stock.txt");
      BufferedReader br = new BufferedReader(or);
      FileWriter dest = new FileWriter("backup_essentials_stock.txt", true);
      String s;

      while ((s = br.readLine()) != null) {
      	dest.write(s);
        dest.write("\n");
      	dest.flush();
      }
      br.close();
      dest.close();
      System.out.println("Backup complete.");
      } catch (IOException e) {
      	// TODO Auto-generated catch block
      	e.printStackTrace();
      }




  }








}




      // System.out.println(" ");
      // System.out.println("Displaying entries... ");
      // System.out.println(" ");

      // System.out.printf("%-8s\t %-12s\t %-5f\t %-5d\n","Product ID","Product Name","Product Price","Quantity");
      // for (Product k: productStock){
      //   System.out.printf("%-3s %-8s\t %-12s\t %-5f\t %-5d\n",t+")",a,b,c,d);
      //   t++;
      // }
      // System.println("Save or Edit?");
      // String ex= in1.nextLine();

      // if(ex.contains("save")){
      //   PrintWriter printWriter = null;
      //   try {
      //     printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
      //   }catch(FileNotFoundException f) {
      //     f.getMessage();
      //   }
      // }
      //
      // printWriter.printf("%-11s\t %-12s\t %-5f\t %-5d\n","Product ID","Product Name","Product Price","Quantity");
      // printWriter.println();
      // for (Product k: productStock){
      //   System.out.printf("%-3s %-8s\t %-12s\t %-5f\t %-5d\n",t+")",a,b,c,d);
      //   t++;
      // }
      //
      // printWriter.close();
