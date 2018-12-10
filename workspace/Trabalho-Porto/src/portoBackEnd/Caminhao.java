package portoBackEnd;

public class Caminhao {
	private String placa;
	private Transportadora transportadora;

	public Caminhao() {
	}

	public Caminhao(String placa, Transportadora transportadora) {
		this.placa = placa;
		this.transportadora = transportadora;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}
}
