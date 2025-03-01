import javax.swing.JOptionPane;
public class ChoosingOptionYesorNo {
	public static void main(String[] args) {
        String[] options = {"Yes", "No"};
        int choice = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Select an option",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if (choice == 0) {
            JOptionPane.showMessageDialog(null, "You chose: Yes");
        } else {
            JOptionPane.showMessageDialog(null, "You chose: No");
        }
        
        System.exit(0);
    }
}
