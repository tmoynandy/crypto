import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class crypto implements ActionListener{
	Frame f;Panel P;
	Label l1,l2,l3;
	TextField t1,t2;
	Button b1,b2;
	crypto(){
		f=new Frame("Encrypting and Decrypting of text files");
		l1=new Label("Copy the path of text file");
		l2=new Label("Example of path->C:\\Users\\ASUS\\Desktop\\checking.txt");
		t1=new TextField(50);
		b1=new Button("ENCRYPT");
		b2=new Button("DECRYPT");
		l3=new Label("--------------------------MESSAGE--------------------------");
		t2=new TextField(25);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(b1);
		f.add(b2);
		f.add(l3);
		f.add(t2);
		f.setVisible(true);
		f.setSize(400,400);
		f.setLayout(new FlowLayout());
	}
	public void actionPerformed(ActionEvent ae){
		int i,a;
		boolean f=false;
		String n,n1="",n2="",n3="";
		n=t1.getText();
		if(ae.getSource()==b1){
			try{
				FileInputStream fi=new FileInputStream(n);
				while((i=fi.read())!=-1){
					a=(i%256)+i;
					n1=n1+(char)a;
				}
				System.out.println(n1);
				n3="Given File has been encrypted";
				t2.setText(n3);
				fi.close();
				FileOutputStream fo=new FileOutputStream(n);
				byte b[]=n1.getBytes();
				fo.write(b);
				fo.close();
				f=true;
			}
				catch(Exception e){
					System.out.println("given file does not exist");
					n3="Given file does not exist";
					t2.setText(n3);
				}
	    }
	    if(f=true){
		if(ae.getSource()==b2){
			try{
				FileInputStream fi=new FileInputStream(n);
				while((i=fi.read())!=-1){
					a=(i%256)/2;
					n2=n2+(char)a;
				}
				System.out.println(n2);
				n3="Given file has been decrypted";
				t2.setText(n3);
				fi.close();
				FileOutputStream fo=new FileOutputStream(n);
				byte b[]=n2.getBytes();
				fo.write(b);
				fo.close();
			}
				catch(Exception e){
					System.out.println("given file does not exist");
					n3="Given file does not exist";
					t2.setText(n3);
				}
		}
	}
	}
	public static void main(String[] args) {
		new crypto();
	}
}
