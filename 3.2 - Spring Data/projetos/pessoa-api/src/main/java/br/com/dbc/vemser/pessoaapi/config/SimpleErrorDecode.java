package br.com.dbc.vemser.pessoaapi.config;

import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.rmi.UnexpectedException;

public class SimpleErrorDecode implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        Response.Body body = response.body();
        if (body == null) {
            return new UnexpectedException("Erro inesperado");
        }

        try {
            String bodyString = IOUtils.toString(body.asInputStream());
            switch (response.status()) {
                case 400:
                    return new RegraDeNegocioException(bodyString);
                default:
                    return new Exception("Generic error");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e;
        }
    }
}
