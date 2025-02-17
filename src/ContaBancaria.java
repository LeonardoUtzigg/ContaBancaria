
import java.time.LocalDate;
import java.time.Duration;

public class ContaBancaria {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    private boolean statusPoup;
    private float saldoPuop;
    private LocalDate dataInicioPoup;
    private LocalDate dataAtual = LocalDate.parse("2024-10-24");


    public void estadoAtual () {
        System.out.println("-----------------------------");
        System.out.println( "Conta: " + this.getNumConta());
        System.out.println(" Dono: "+ this.getDono());
        System.out.println(" Tipo:" +this.getTipo());
        System.out.println(" Status:" + this.getStatus());
        System.out.println("Saldo:" + this.getSaldo());
        System.out.println("Status da Poupança:" + this.getStatusPoup());
        System.out.println("Saldo em poupança:" + this.getSaldoPuop());
        System.out.println("Poupança iniciada em: " +this.getDataInicioPoup() + " e a taxa de juros aplicada é de 1% ao mês.");
        System.out.println("Data atual é: " +this.dataAtual);


    }


    public void taxaDeJuro() {
        if (getStatusPoup()) {
            long diasPassados = java.time.Duration.between(dataInicioPoup.atStartOfDay(), dataAtual.atStartOfDay()).toDays();

            // Aplica a taxa a cada 30 dias
            if (diasPassados >= 30) {
                int aplicacoes = (int) (diasPassados / 30); // Número de aplicações de juros
                this.setSaldoPuop(this.getSaldoPuop() * (1 + 0.01f * aplicacoes)); // Aplica a taxa de 1%
                System.out.println("Taxa de juros de 1% aplicada à poupança: " + aplicacoes + " vezes.");
            } else {
                System.out.println("Ainda não se passaram 30 dias da última aplicação de juros.");
            }
        }
    }


    public void avancarData(int dias) {
        this.dataAtual = this.dataAtual.plusDays(dias);
    }


    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if ( t == "CC") {
            this.setSaldo (50);
        } else if ( t == "CP") {
            this.setSaldo(150);
        }
        System.out.println(" Conta aberta com Sucesso!");

    }

    public void criarPoup (){

        if (this.getStatus() && this.getSaldo() >= 30){
        this.setStatusPoup(true);
        this.setSaldo(this.getSaldo() -30);
        this.setSaldoPuop(30);
        this.dataInicioPoup = getDataAtual();
        System.out.println("Sua poupança foi aberta com sucesso!");
        }  else if (this.getSaldo() < 30) {
        this.setStatusPoup(false);
        System.out.println("Não foi possivel abrir uma poupança pois infelizmente o seu saldo foi insuficiente para os resquisitos de abertura!");
        }

    }

    public void depositarPoup (float v){
        if (this.getStatus() && this.getStatusPoup()) {
            if (this.getSaldo() >= v)
                this.setSaldoPuop(this.getSaldoPuop() + v);
            System.out.println(" Deposito feito em sua poupança com sucessso.");
        } else {
            this.setStatusPoup(false);
            System.out.println(" Impossivel depositar na poupança pois não há conta aberta");
        }
    }

    public void sacarPoup (float V) {
        if (this.getStatusPoup());
           if( this.getSaldoPuop() >= V);
           this.setSaldoPuop(this.getSaldoPuop() - V);
           System.out.println("Saque efetuado com sucesso!");
    }

    public void fecharContaPoup() {
        if (getSaldoPuop() > 0) {
        System.out.println (" Impossivel fechar a poupança pois há saldo dentro");
        } else {
            this.setStatusPoup(false);
            System.out.println("Conta poupança fechada com sucesso!");
        }
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println(" Impossivel fechar conta pois há saldo dentro");
        } else if ( this.getSaldo() < 0) {
            System.out.print ( " imporssivel fechar conta pois há débito pendente");
        } else if (this.getStatusPoup()) {
            System.out.println("Impossivel fechar conta pois há uma poupança em aberto!");
            this.setStatus(false);
            System.out.println( "Conta fechada com sucesso!");
        }
    }

    public void depositar(float v) {
       if (this.getStatus()) {
           this.setSaldo(getSaldo() + v);
           System.out.println("Depósito realizado na conta de " + this.getDono()+" com Êxito!");
       } else {
           System.out.println(" Impossivel depositar em uma conta fechada!");
        }
    }

    public void sacar(float v) {
       if (this.getStatus()) {
           if (this.getSaldo() >= v ){
               this.setSaldo(this.getSaldo() - v);
               System.out.println("Saque realizado na conta de " + this.getDono() +" com Êxito!" );
           } else {
               System.out.println("Saldo insuficiente para saque");
           }

       }
    }

    public void pagarMensal() {
       int v = 0;
       if (this.getTipo() == "CC") {
           v = 12;
       } else if (this.getTipo() == "CP") {
           v = 20;
       }
       if (this.getSaldo() > v) {
           this.setSaldo(this.getSaldo() - v);
           System.out.println(" Mensalidade Paga com sucesso!");
       } else {
           System.out.println(" Saldo insuficiente!");
       }
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public LocalDate getDataInicioPoup() {
        return dataInicioPoup;
   }

    public void setDataInicioPoup(LocalDate dataInicioPoup) {
        dataInicioPoup = dataInicioPoup;
   }

    public boolean isStatusPoup() {
        return statusPoup;
    }

    public float getSaldoPuop() {
        return saldoPuop;
    }

    public void setSaldoPuop(float saldoPuop) {
        this.saldoPuop = saldoPuop;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean getStatusPoup() {
        return statusPoup;
    }

    public void setStatusPoup(boolean statusPoup) {
        this.statusPoup = statusPoup;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}





