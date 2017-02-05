
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author Gabo Quesada
 */
public class Controller implements ActionListener{
  
    private JButton btnenviar;
    private JButton btnlimpiar;
    private JScrollPane jScrollPane1;
    private JTextField txtedad;
    private JTextField txtnombre;
    private JTextField txtojos;
    private JTextField txtpeso;
    private JTextField txtpiel;
    private JTextArea txtrespueta;
    private JTextField txtserver;
    private Model model;

    public Controller() {
    }

    public Controller(JButton btnenviar, JButton btnlimpiar, JScrollPane jScrollPane1, JTextField txtedad, JTextField txtnombre, JTextField txtojos, JTextField txtpeso, JTextField txtpiel, JTextArea txtrespueta, JTextField txtserver) {
        this.btnenviar = btnenviar;
        this.btnlimpiar = btnlimpiar;
        this.jScrollPane1 = jScrollPane1;
        this.txtedad = txtedad;
        this.txtnombre = txtnombre;
        this.txtojos = txtojos;
        this.txtpeso = txtpeso;
        this.txtpiel = txtpiel;
        this.txtrespueta = txtrespueta;
        this.txtserver = txtserver;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
      
        
        if(btnenviar.equals(e.getSource())){JOptionPane.showMessageDialog(null,"Enviado.");
        
        txtrespueta.setText(getRecurso());
        }
         if(btnlimpiar.equals(e.getSource())){JOptionPane.showMessageDialog(null,"Limpiado.");}
        //if(btnlimpiar.getActionCommand().equals("limpiar")){JOptionPane.showMessageDialog(null,"Limpiado.");}
    }
    
    
    
    
    public String getRecurso()
    {
    
        model = new Model();
        model.setNombre(txtnombre.getText());
        model.setEdad(txtedad.getText());
        model.setServer(txtserver.getText());
        
        DAOImpl enviar = new DAOImpl();
        
        return enviar.setPost(model);
    

    }
}
