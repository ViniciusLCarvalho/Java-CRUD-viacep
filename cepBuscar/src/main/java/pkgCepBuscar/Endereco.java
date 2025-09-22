package pkgCepBuscar;

import jakarta.json.bind.annotation.JsonbProperty;

public class Endereco {

	private int id;

	@JsonbProperty(value = "cep")
	private String cep;

	@JsonbProperty(value = "logradouro")
	private String logradouro;

	@JsonbProperty(value = "complemento")
	private String complemento;

	@JsonbProperty(value = "bairro")
	private String bairro;

	@JsonbProperty(value = "localidade")
	private String localidade;

	@JsonbProperty(value = "uf")
	private String uf;

	@JsonbProperty(value = "ibge")
	private String ibge;

	@JsonbProperty(value = "gia")
	private String gia;

	@JsonbProperty(value = "ddd")
	private String ddd;

	@JsonbProperty(value = "sia")
	private String siafi;

	// GET
	public int getId() {
		return id;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}

	public String getDdd() {
		return ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	// SET
	public void setId(int id) {
		this.id = id;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

}
