package javacodegeeks.com.gkatzioura.design.structural.composite1;

public class General implements  Officer {

    @Override
    public void assignOrder(MilitaryPersonnel militaryPersonnel) {
        militaryPersonnel.executeOrder();
    }
}
