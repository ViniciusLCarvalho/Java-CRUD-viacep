package pkgCepBuscar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;

import jakarta.enterprise.inject.Model;
import jakarta.faces.event.AjaxBehaviorEvent;

@Model
public class EnderecoBean {

	private Endereco endereco;
	private EnderecoDAO enderecoDAO;
	private List<Endereco> enderecos;
	private Emails emails;

	public EnderecoBean() {
		endereco = new Endereco();
		enderecoDAO = new EnderecoDAO();
		enderecos = enderecoDAO.getListaEndereco();
		emails = new Emails();
	}

	// GET
	public Endereco getEndereco() {
		return endereco;
	}

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	// SET
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void adicionar() {
		enderecoDAO.save(endereco);
		enderecos.add(endereco);
		emails.enviarEmail();
		endereco = new Endereco();
	}

	public void excluir() {
		enderecoDAO.exclude(endereco.getId());
		enderecos = enderecoDAO.getListaEndereco();
		endereco = new Endereco();
	}

	public void alterar() {
		enderecoDAO.alter(endereco);
		enderecos = enderecoDAO.getListaEndereco();
		endereco = new Endereco();
	}

	public void pesquisaCep(AjaxBehaviorEvent event) {
		try {
			URL url = new URL("https://viacep.com.br/ws/"+endereco.getCep()+"/json");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			String cep = "";
			StringBuilder jsonCep = new StringBuilder();
			
			while((cep = br.readLine()) != null) {
				jsonCep.append(cep);
			}
			
			Gson gson = new Gson();		
			Endereco enderecoGson = gson.fromJson(jsonCep.toString(), Endereco.class);
			
			endereco.setCep(enderecoGson.getCep());
			endereco.setLogradouro(enderecoGson.getLogradouro());
			endereco.setComplemento(enderecoGson.getComplemento());
			endereco.setBairro(enderecoGson.getBairro());
			endereco.setLocalidade(enderecoGson.getLocalidade());
			endereco.setUf(enderecoGson.getUf());
			endereco.setIbge(enderecoGson.getIbge());
			endereco.setGia(enderecoGson.getGia());
			endereco.setDdd(enderecoGson.getDdd());
			endereco.setSiafi(enderecoGson.getSiafi());
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	
	
	}
}
