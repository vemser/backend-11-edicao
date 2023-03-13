package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final Configuration fmConfiguration;
    @Value("${spring.mail.username}")
    private String from;
    private static final String TO = "marcklen.guimaraes@dbccompany.com.br";
    private final JavaMailSender emailSender;

    public void enviarEmailParaPessoaCadastrada(PessoaDTO pessoa) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        Integer op = 1;
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");

            mimeMessageHelper.setText(getPessoaTemplate(pessoa, op), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public void enviarEmailParaPessoaAtualizada(PessoaDTO pessoa) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        Integer op = 2;
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");

            mimeMessageHelper.setText(getPessoaTemplate(pessoa, op), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public void enviarEmailParaPessoaExcluida(PessoaDTO pessoa) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        Integer op = 3;
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");

            mimeMessageHelper.setText(getPessoaTemplate(pessoa, op), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public String getPessoaTemplate(PessoaDTO pessoa, Integer opc) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Sistema");
        dados.put("pessoa", pessoa);

        switch (opc) {
            case 1:
                Template template1 = fmConfiguration.getTemplate("email-template-pessoa-inserir.ftl");
                String html1 = FreeMarkerTemplateUtils.processTemplateIntoString(template1, dados);
                return html1;
            case 2:
                Template template2 = fmConfiguration.getTemplate("email-template-pessoa-atualizar.ftl");
                String html2 = FreeMarkerTemplateUtils.processTemplateIntoString(template2, dados);
                return html2;
            case 3:
                Template template3 = fmConfiguration.getTemplate("email-template-pessoa-excluir.ftl");
                String html3 = FreeMarkerTemplateUtils.processTemplateIntoString(template3, dados);
                return html3;
            default:
                return "Opção inválida!";

        }
    }

    public void enviarEmailEnderecoCriado(EnderecoDTO enderecoDTO, PessoaDTO pessoa) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        Integer op = 1;
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");

            mimeMessageHelper.setText(getEnderecoTemplate(enderecoDTO, pessoa, op), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public void enviarEmailEnderecoAtualizado(EnderecoDTO enderecoDTO, PessoaDTO pessoa) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        Integer op = 2;
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");

            mimeMessageHelper.setText(getEnderecoTemplate(enderecoDTO, pessoa, op), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public void enviarEmailEnderecoDeletado(EnderecoDTO enderecoDTO, PessoaDTO pessoa) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        Integer op = 3;
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");

            mimeMessageHelper.setText(getEnderecoTemplate(enderecoDTO, pessoa, op), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public String getEnderecoTemplate(EnderecoDTO endereco, PessoaDTO pessoa, Integer opc) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Sistema");
        dados.put("pessoa", pessoa);
        dados.put("endereco", endereco);

        switch (opc) {
            case 1:
                Template template1 = fmConfiguration.getTemplate("email-template-endereco-inserir.ftl");
                String html1 = FreeMarkerTemplateUtils.processTemplateIntoString(template1, dados);
                return html1;
            case 2:
                Template template2 = fmConfiguration.getTemplate("email-template-endereco-atualizar.ftl");
                String html2 = FreeMarkerTemplateUtils.processTemplateIntoString(template2, dados);
                return html2;
            case 3:
                Template template3 = fmConfiguration.getTemplate("email-template-endereco-excluir.ftl");
                String html3 = FreeMarkerTemplateUtils.processTemplateIntoString(template3, dados);
                return html3;
            default:
                return "Opção inválida!";

        }
    }
}
