public class No {
    
    int dado;
    No anterior, proximo;

    public No(int novoDado){
        dado = novoDado;
        anterior = null;
        proximo = null;
    }

    @Override
    public String toString() {
        return "No [anterior=" + anterior + ", dado=" + dado + " , proximo=" + proximo + "]";
    }

}
