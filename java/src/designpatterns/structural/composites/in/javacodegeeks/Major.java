package in.javacodegeeks;

import java.util.ArrayList;
import java.util.List;
/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Major implements MilitaryPersonnel, Officer {

    private List<MilitaryPersonnel> lowerRankersonel = new ArrayList<>();

    public Major(List<MilitaryPersonnel> lowerRankersonel) {
        this.lowerRankersonel = lowerRankersonel;
    }

    public void addPrivateUnderCommand(Private soldier) {
        lowerRankersonel.add(soldier);
    }

    public void addLieutenantUnderCommand(Lieutenant lieutenant) {
        lowerRankersonel.add(lieutenant);
    }

    @Override
    public void executeOrder() {
        System.out.println("Major executing order assigned");
        //other actions
        this.lowerRankersonel.forEach(lw->assignOrder(lw));
        //other actions
    }

    @Override
    public void assignOrder(MilitaryPersonnel militaryPersonnel) {
        militaryPersonnel.executeOrder();
    }

}
