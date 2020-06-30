/*
 * Konvertuesi_i_numrave.java
 *
 * Created on 2007-07-08, 4.12.MD
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 * @author Armend Shabani
 * @author Ahmet N Murati
 */
import javax.swing.*;

public class Konvertuesi_i_numrave {
    
    public static int[] numrat = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] shkronjat = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    public static void main(String [] args) {
        Konvertuesi_i_numrave kin = new Konvertuesi_i_numrave();
        
        System.out.println("399 \t= " + kin.arabNeRomak(399));
        System.out.println("CCCXCIX = " + kin.romakNeArab("CCCXCIX"));
    }
    
    public String arabNeRomak(int nrArab) //kjo metod bene konvertimin e numrave prej atyre arab ne romak
    {
        int n = nrArab; //vendi ku merret vlera e numrit arab
        
        String nrRomak = "";  //vendi ku do te ruhet numri romak
        
        for (int i = 0; i < numrat.length; i++) {
            while (nrArab >= numrat[i]) {
                nrRomak += shkronjat[i];
                nrArab -= numrat[i];
            }
        }
        //JOptionPane.showMessageDialog(null, "Numri " + n + " në formën romake është " + nrRomak); //paraqet vleren e konvertuar
        return nrRomak; //kthen vleren e nrArab
    }
    
    public int romakNeArab(String nr_romak) //kjo metod bene konvertimin e numrave prej atyre romak ne arab
    {
        nr_romak = nr_romak.toUpperCase(); //tere stringun e kthen ne shkronja te medha
        
        nr_romak = nr_romak.trim(); //stringut i largohen hapesirat
        
        int i = 0;
        
        int nr_arab = 0; //ketu ruhet vlera e konvertuar e numrit romak
        
        while (i < nr_romak.length()) //nese gjatesia e stringut eshte me e madhe se 'i'
        {
            char shkronja = nr_romak.charAt(i); //merret shkronja nga stringu ne poziten e caktuar nga 'i'
            
            int numri = shkronjaNeNumer(shkronja); //vlera e kthyer nga shkronjaNeNumer i ndahet variables 'numri'
            
            if (numri < 0) //nese vlera e kthyer eshte me e vogel se 0 detektohet se eshte dhene karakter ilegal
            { JOptionPane.showMessageDialog(null, "Stringu i dhënë " + nr_romak + " nuk është numër romak.");
            }
            
            i++;  //'i' rritet per 1
            
            if (i == nr_romak.length()) //nese gjatesia e nr_romak eshte e barabart me vleren e 'i' vlera i shtohet nr_arab
            { nr_arab += numri; }
            
            else {
                int numriTjeter = shkronjaNeNumer(nr_romak.charAt(i)); //variables numriTjeter i ndahet vlera e kthyer nga shkronjaNeNumer e percaktuar nga pozita e karakterit qe caktohet nga 'i'
                
                if (numriTjeter > numri) {
                    nr_arab += (numriTjeter - numri); //nr_arab i shtohet vlera e mbledhur e (numriTjeter-numri) dhe vleres se tij paraprake
                    i++; //'i' rritet per 1
                }
                
                else { nr_arab += numri; }
            }
            
            if(nr_arab > 399) //nese vlera e llogaritur e nr_arab eshte me e madhe se 399 programi ndalet
            {
                JOptionPane.showMessageDialog(null, "Programi nuk është dizajnuar që të kalkuloj vlera më të mëdha se 399.");
            }
        }
        
        //JOptionPane.showMessageDialog(null, "Numri " + nr_romak + " në formën arabe është " + nr_arab); //paraqet vleren e kalkuluar
        return nr_arab;  //kthen vleren e nr_romak
    }
    
    private int shkronjaNeNumer(char shkronja) //kjo metod ndihmon metoden romakNeArab ne konvertimin e numrave
    {
        switch (shkronja) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            default:   return -1; //nese nuk eshte asnje rast prej tyre kthen vleren '-1'
        }
    }
}