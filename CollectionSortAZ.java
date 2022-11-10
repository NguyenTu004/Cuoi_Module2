import java.util.Comparator;

public class CollectionSortAZ implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        if (o1.getMediumScore() > o2.getMediumScore()){
            return 1;
        }else if(o1.getMediumScore() == o2.getMediumScore()){
            return 0;
        }else{
            return -1;
        }
    }
}
