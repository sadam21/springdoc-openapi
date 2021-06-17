package test.org.springdoc.api.app81;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.EmailSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.RepositoryRestResourceProvider;
import org.springdoc.core.fn.RouterOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class RefRepositoryRestResourceProvider implements RepositoryRestResourceProvider {

    @Override
    public List<RouterOperation> getRouterOperations(OpenAPI openAPI) {
        final RouterOperation operation = new RouterOperation();

        final Parameter parameter = new Parameter()
                .in(ParameterIn.PATH.toString())
                .name("myparameter")
                .schema(new EmailSchema());

        openAPI.getComponents().addParameters("myparameter", parameter);

        final Parameter refParameter = new Parameter()
                .$ref("myparameter");


        return Collections.singletonList(operation);
    }

    @Override
    public Map<String, Object> getRepositoryRestControllerEndpoints() {
        return Collections.emptyMap();
    }

    @Override
    public Map getHandlerMethods() {
        return Collections.emptyMap();
    }

    @Override
    public void customize(OpenAPI openAPI) { }
}
