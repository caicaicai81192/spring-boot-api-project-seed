package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractIpampasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author ${author}
 * @date ${date}
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractIpampasService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
