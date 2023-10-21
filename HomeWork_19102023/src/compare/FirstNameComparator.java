package compare;

import java.util.Comparator;
import fullName.FullName;
public class FirstNameComparator implements Comparator<FullName> {
    @Override
    public int compare(FullName o1, FullName o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
