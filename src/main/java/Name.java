import org.apache.commons.lang3.StringUtils;

public class Name {

    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name can't null");
        }
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("can't exceed over 5");
        }
        this.name = name.trim();
    }


    public String getName() {
        return name;
    }
}
