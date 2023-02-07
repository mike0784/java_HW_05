import java.util.ArrayList;

public class TelephoneList implements Comparable<TelephoneList> {
    private ArrayList<String> telephone;
    public TelephoneList()
    {
        telephone = new ArrayList<>();
    }

    public void setTelephone(String tel)
    {
        telephone.add(tel);
    }

    public ArrayList getTelephone()
    {
        return telephone;
    }

    public Integer getCount()
    {
        return telephone.size();
    }

    public int compareTo(TelephoneList other)
    {
        return this.getCount().compareTo(other.getCount());
    }
}
