import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Model;

public class TestLigneDevis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model m = new Model();
		m.setId(1);
				
		LigneDevis d1 = new LigneDevis();		
		d1.setId(1);
		d1.setQuantite(11);
		d1.setModel(m);
		
		LigneDevis d2 = new LigneDevis();
		d2.setId(1);
		d2.setQuantite(11);
		d2.setModel(m);
		
		System.out.println(d1.equals(d2));
	}

}
