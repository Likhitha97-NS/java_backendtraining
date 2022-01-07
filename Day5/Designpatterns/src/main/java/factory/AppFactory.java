package factory;

public class AppFactory {

    public CardFactory getFactory(String type){
        if(type.equals("card")) return CardFactory.newInstance();
        if(type.equals("coin")) return CardFactory.newInstance();

        return null;
    }
}
