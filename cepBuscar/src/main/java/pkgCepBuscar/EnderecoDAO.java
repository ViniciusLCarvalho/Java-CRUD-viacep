package pkgCepBuscar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.inject.Model;
@Model
public class EnderecoDAO {

	
	private Connection con;
	private String query;
	private PreparedStatement st;
	private ResultSet rs;
	
	public boolean save(Endereco endereco) {
		int i = 0;
		
		query = "INSERT INTO Enderecos(cep, logradouro, complemento, bairro, localidade, uf) VALUES (?,?,?,?,?,?)";
			
		try {
			con = Conexao.conectar();
			st = con.prepareStatement(query);
			st.setString(++i, endereco.getCep());
			st.setString(++i, endereco.getLogradouro());
			st.setString(++i, endereco.getComplemento());
			st.setString(++i, endereco.getBairro());
			st.setString(++i, endereco.getLocalidade());
			st.setString(++i, endereco.getUf());
			st.execute();
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean exclude(int id) {
		query = "DELETE FROM Enderecos WHERE id = ?";
		
		try {
			con = Conexao.conectar();
			st = con.prepareStatement(query);
			st.setInt(1, id);
			st.execute();
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean alter(Endereco endereco) {
		int i = 0;
		query = "UPDATE Enderecos SET cep = ?,	\r\n"
				+ "logradouro = ?, complemento = ?,	\r\n"
				+ "bairro = ?, localidade = ?,	\r\n"
				+ "uf = ? WHERE id = ?";
		
		try {
			con = Conexao.conectar();
			st = con.prepareStatement(query);
			st.setString(++i, endereco.getCep());
			st.setString(++i, endereco.getLogradouro());
			st.setString(++i, endereco.getComplemento());
			st.setString(++i, endereco.getBairro());
			st.setString(++i, endereco.getLocalidade());
			st.setString(++i, endereco.getUf());
			st.setInt(++i, endereco.getId());
			st.execute();
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Endereco> getListaEndereco(){
		
		List<Endereco> lista = new ArrayList<Endereco>();
		Endereco endereco;
		
		query = "SELECT * FROM Enderecos";
		
		try {
			con = Conexao.conectar();
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			
			while(rs.next()) {
				endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setCep(rs.getString("cep"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setLocalidade(rs.getString("localidade"));
				endereco.setUf(rs.getString("uf"));
				
				lista.add(endereco);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return lista;
	}
	
	
}
