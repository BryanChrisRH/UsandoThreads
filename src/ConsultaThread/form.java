package ConsultaThread;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class form{

    JFrame ventFrame;
    JTextField textField;
    JTextArea textArea;
    JButton bJButton;
    BufferedReader file;

    public form(){
        ventFrame = new JFrame();
        textField = new JTextField(20);
        bJButton = new JButton("inicio");
        textArea = new JTextArea();
        JPanel panel=new JPanel();


       // ventFrame.setLayout(new FlowLayout());
       panel.add(textField); 
       panel.add(bJButton);
        
        ventFrame.add(textArea,BorderLayout.CENTER);
        ventFrame.add(panel,BorderLayout.NORTH);;

        bJButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutorService service = Executors.newSingleThreadScheduledExecutor();
                service.execute(()->{
                    try {
                        file = new BufferedReader(new FileReader("C:\\Users\\cagua\\IdeaProjects\\untitled\\src\\ConsultaThread\\medals.csv"));
                        Scanner sc = new Scanner(file);
                        while (sc.hasNext()){
                            String Linea = sc.nextLine();
                            textArea.append(Linea+"\n");
                            Thread.sleep(500);
                        }

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                });
            }
        });
                    
        ventFrame.setVisible(true);
        ventFrame.setSize(800,600);
        ventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new form();
    }
}