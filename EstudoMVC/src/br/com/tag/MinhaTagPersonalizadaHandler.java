package br.com.tag;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import br.com.model.Usuario;

public class MinhaTagPersonalizadaHandler extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpSession session = pageContext.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		try {
			if (usuario != null) {

				out.println("Usuário :" + usuario.getUsuario());

			}else {
				out.print("<a href=\""+pageContext.getRequest().getServletContext().getContextPath()+"/login"+"\">Login</a><br/>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;

	}

}










