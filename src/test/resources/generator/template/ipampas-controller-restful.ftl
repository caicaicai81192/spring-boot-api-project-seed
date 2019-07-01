package ${basePackage}.web;

import ${basePackage}.core.AbstractIpampasController;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.ipampas.framework.model.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ${author}
 * @date ${date}
 */
@RestController
@RequestMapping("${baseRequestMapping}")
@Api
public class ${modelNameUpperCamel}Controller extends AbstractIpampasController{
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @ApiOperation("create ${modelNameLowerCamel}")
    @PostMapping
    public Integer add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        //
        return ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
    }

    @ApiOperation("delete ${modelNameLowerCamel}")
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Long id) {
        //
        return ${modelNameLowerCamel}Service.deleteLogicalById(id);
    }

    @ApiOperation("modify ${modelNameLowerCamel}")
    @PutMapping
    public Integer update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        //
        return ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    }

    @ApiOperation("${modelNameLowerCamel} detail")
    @GetMapping("/{id}")
    public ${modelNameUpperCamel} detail(@PathVariable Long id) {
        //
        return ${modelNameLowerCamel}Service.findById(id);
    }

    @ApiOperation("pageList")
    @GetMapping
    public Page pageList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        //
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(new Object());
        return PageUtils.transToPage(list);
    }
}
