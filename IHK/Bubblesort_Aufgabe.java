import java.time.Month;
import java.util.function.BiFunction;
import java.util.function.Function;

// aktienKurs

class Tageskurs
{
    private Date date;
    private double aktienKurs;
    private double daxWert;
    private double prozVaktie;
    private double prozVDAX;

    
    public Tageskurs(){}

    public Tageskurs(Date date, double a, double d, double prozVA,double prozVD)
    {
        this.date = date;
        this.aktienKurs = a;
        this.daxWert = d;
        this.prozVaktie = prozVA;
        this.prozVDAX = prozVD;

    }
    
    public double getDateValue()
    {
        return this.date.getValue();
    }
    public double getAktienKurs()
    {
        return this.aktienKurs;
    }
    public static void ListSort(Tageskurs tlist[], 
                                BiFunction <Tageskurs, Tageskurs, Integer> vergleichefunc)
    {
        
        //
        boolean loop;
        for(int i = 0; i<tlist.length; i++)
        {
            loop = false;
                for(int j = 0; j<tlist.length-i-1; j++)
                {

                    if(vergleichefunc.apply(tlist[j], tlist[j+1]) == 0)
                    {
                        Tageskurs temp = tlist[j+1];
                        tlist[j+1] = tlist[j];
                        tlist[j] = temp;
                        loop = true;
                    }
                
                }
                if(!loop) 
                {
                    i=tlist.length;
                }

            
            

        }

    }

    public static int VergleichenAktionKurs(Tageskurs t1, Tageskurs t2)
    {
        return (t1.getAktienKurs() > t2.getAktienKurs() ? 1 : 0);
    }

    public static int VergleichenDatum(Tageskurs t1, Tageskurs t2)
    {
        
        return (t1.getDateValue() > t2.getDateValue() ? 0 : 1);
    }

    public void PrintObj()
    {
        System.out.println(this.aktienKurs+" "+this.daxWert+" "+this.prozVDAX+" "+this.prozVaktie);
    }



    public static void main(String[] args) {
        Date d = new Date(10,2,1923);

        Tageskurs listTageskurs[] = {
            new Tageskurs(new Date(10,4,2005),180,1001,100,100),
            new Tageskurs(new Date(10,2,2024), 200, 23, 230,130),
            new Tageskurs(new Date(10,4,2005),120,1001,100,100),
            new Tageskurs(new Date(10,4,2005),100,1001,100,100),
            new Tageskurs(new Date(10,4,2005),160,1001,100,100),
        };  

        BiFunction <Tageskurs, Tageskurs, Integer> vergleichefunc = (a,b) -> a.getAktienKurs() > b.getAktienKurs() ? 0 : 1;

        Tageskurs.ListSort(listTageskurs, vergleichefunc);
        for(int i=0; i<listTageskurs.length; i++)
        {
            listTageskurs[i].PrintObj();
        }

    }




}

public class Date
{
    private int day;
    private int month;
    private int year;
    
    public Date(){}
    public Date(int d, int m, int y)
    {
        this.day = d;
        this.month = m;
        this.year = y;
    }
    public int getValue()
    {
        return this.day+this.month+this.year;
    }



}
