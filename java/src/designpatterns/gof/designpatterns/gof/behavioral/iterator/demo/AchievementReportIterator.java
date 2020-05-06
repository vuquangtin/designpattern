package designpatterns.gof.behavioral.iterator.demo;

/**
 * <h1>Iterator</h1> Cung cấp một cách để truy xuất các thành phần của một đối
 * tượng tập hợp một cách tuần tự mà không cho thấy sự biểu diễn representation
 * bên dưới của nó. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class AchievementReportIterator implements Iterator {
    private AchievementReport achievementReport;
    private int index;

    public AchievementReportIterator(AchievementReport AchievementReport) {
        achievementReport = AchievementReport;
    }

    @Override
    public boolean hasNext() {
        return index < achievementReport.size()
                && achievementReport.get(index) != null;
    }

    @Override
    public Achievement next() {
        return achievementReport.get(index++);
    }
}