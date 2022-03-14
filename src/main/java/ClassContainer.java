import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    Map<String, Class> map = new HashMap<>();

    public Map<String, Class> getMap() {
        return map;
    }



    public ClassContainer() {
    }

    @Override
    public String toString() {
        return "ClassContainer{" +
                "map=" + map +
                '}';
    }

    public void getInfos(){
        for (var c : map.entrySet()) {
            System.out.println(c.getKey());
        }
    }

    public void addClass(String s, double size, Class c){
        Class newClass = new Class();
        newClass.setNameOfGroup(s);
        newClass.setMaxNumberOfStudents(size);
        newClass.setStudentsList(c.getStudentsList());
        map.put(s, newClass);
    }

    public void removeClass(String s){
        map.remove(s);
    }

    public List<Class> findEmpty(){
        List<Class> emptyList = new ArrayList<>();
        for (Class c: map.values()) {
            if(c.getStudentsList().size() == 0){
                emptyList.add(c);
            }
        }
        return emptyList;
    }

    public void summary(){
        double currentSize = 0;
        for (Class c: map.values()) {
            currentSize = (c.getStudentsList().size() / c.getMaxNumberOfStudents()) * 100;
            System.out.println("Nazwa grupy: " + c.getNameOfGroup() + " zapelnienie: " + currentSize + " %");
        }
    }
}
