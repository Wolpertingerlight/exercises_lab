package Exercise_4;

import java.util.Collections;
import java.util.LinkedList;

public class SortedIntegerList {
    private final LinkedList<Integer> list;
    private final boolean repeatedElements;
    public SortedIntegerList(boolean repeatedElements){
        this.repeatedElements = repeatedElements;
        list = new LinkedList<>();
    }
    public int getSize(){
        return list.size();
    }
    public int getElement(int index){
        if (index < 0 || index > this.list.size() || list.get(0) == null) throw new RuntimeException("Нельзя получить такой элемент");
        else return list.get(index);
    }
    public void add(int number){
        if (this.repeatedElements) this.list.add(number);
        else {
            if (!this.list.contains(number)) this.list.add(number);
        }
        Collections.sort(this.list);
    }
    public void remove(int number){
        if (this.list.contains(number)) this.list.remove(number);
        Collections.sort(this.list);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof SortedIntegerList temp) {
            if (this.list.size() == temp.list.size()){
                for(int i = 0; i < this.list.size(); i++){
                    if (!this.list.get(i).equals(temp.list.get(i))) return false;
                }
                return true;
            } else return false;
        }
        return false;
    }
}
