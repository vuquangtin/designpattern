package in.javacodegeeks;

public class General implements  Officer {

    @Override
    public void assignOrder(MilitaryPersonnel militaryPersonnel) {
        militaryPersonnel.executeOrder();
    }
}
