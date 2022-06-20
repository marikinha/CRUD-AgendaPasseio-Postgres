package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.AgendaDao;
import entidade.Agenda;

@ManagedBean
public class AgendaBean {
	
	private Agenda agenda = new Agenda();
	private List<Agenda> agenda1;

	public String salvar() {
		try {
			AgendaDao.salvar(agenda);
			agenda = new Agenda();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Local salvo com sucesso."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar o Local."));
		}
		return null;
	}
	
	public String editar() {
		try {
			AgendaDao.editar(agenda);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Local editado com sucesso."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao editar o local."));
		}
		return null;
	}
	
	public String excluir() {
		try {
			AgendaDao.excluir(agenda);
			agenda1.remove(agenda);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Local deletado com sucesso."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao excluir o local."));
		}
		return null;
	}

	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Agenda> getAgenda1() {
		
		if (agenda1 == null) {
			agenda1 = AgendaDao.listar();
		}
		return agenda1;
	}

	public void setAgenda1(List<Agenda> agenda1) {
		this.agenda1 = agenda1;
	}
	

}
