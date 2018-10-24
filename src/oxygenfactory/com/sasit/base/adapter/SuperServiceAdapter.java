package oxygenfactory.com.sasit.base.adapter;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import oxygenfactory.com.sasit.base.annotation.PrimaryKey;
import oxygenfactory.com.sasit.base.delegate.ServiceDelegate;
import oxygenfactory.com.sasit.base.delegate.ServiceSaveDelegate;
import oxygenfactory.com.sasit.base.exception.CoreQueryException;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;
import oxygenfactory.com.sasit.base.service.SuperService;
import oxygenfactory.com.sasit.base.util.ReflectionUtils;

@Transactional(rollbackFor = Exception.class)
public abstract class SuperServiceAdapter<T extends SuperMapper> implements SuperService<T> {

    protected T mapper;

    public abstract void setMapper(T mapper);

    @Override
    public <A> void saveEntity(A entity, ServiceSaveDelegate...delegate) {
        Object primaryKey = ReflectionUtils.getAnnotatedFieldValue(entity, PrimaryKey.class);
        if (primaryKey != null) {
            mapper.update(entity);
        } else {
            mapper.insert(entity);
        }
        if (ArrayUtils.isNotEmpty(delegate)) {
        	for (ServiceSaveDelegate ssd : delegate) {
				ssd.afterHandle(entity);
			}
        }
    }

    @Override
    public <A> void dropEntity(A keyOrEntity, ServiceDelegate...delegate) {
        mapper.delete(keyOrEntity);
        if (ArrayUtils.isNotEmpty(delegate)) {
        	for (ServiceDelegate sd : delegate) {
				sd.afterHandle(keyOrEntity);
			}
        }
    }

    @Override
    public <K, A> K findEntity(A...param) {
        if (ArrayUtils.isNotEmpty(param)) {
            if (param.length == 1)
                return mapper.findEntity(param[0]);
            else
                throw new CoreQueryException("findEntity浼犲叆鐨勫彲鍙樺弬鏁颁釜鏁颁笉鑳藉浜庝竴涓�");
        } else
            return mapper.findEntity();

    }

    @Override
    public <K, A> List<K> findEntityList(A...param) {
        if (ArrayUtils.isNotEmpty(param)) {
            if (param.length == 1)
                return mapper.findEntityList(param[0]);
            else
                throw new CoreQueryException("findEntity浼犲叆鐨勫彲鍙樺弬鏁颁釜鏁颁笉鑳藉浜庝竴涓�");
        } else
            return mapper.findEntityList();
    }

    @Override
    public <K, A> List<K> findEntityListForPages(A param, PageBounds pageBounds) {
        return mapper.findEntityListForPages(param, pageBounds);
    }

    @Override
    public <K, A> K findEntityBySQLId(String sqlId, A...params) {
        return (K) ReflectionUtils.invokeMethod(mapper, sqlId, params);
    }


    @Override
    public <K, A> List<K> findEntityListBySQLId(String sqlId, A...params) {
        return (List<K>) ReflectionUtils.invokeMethod(mapper, sqlId, params);
    }
}
