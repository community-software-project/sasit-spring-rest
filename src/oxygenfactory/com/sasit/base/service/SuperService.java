package oxygenfactory.com.sasit.base.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import oxygenfactory.com.sasit.base.delegate.ServiceDelegate;
import oxygenfactory.com.sasit.base.delegate.ServiceSaveDelegate;
import oxygenfactory.com.sasit.base.mapper.SuperMapper;

public interface SuperService<T extends SuperMapper> {

    public <A> void saveEntity(A entity, ServiceSaveDelegate...delegate);
    
    public <A> void dropEntity(A keyOrEntity, ServiceDelegate...delegate);

    public <K, A>K findEntity(@SuppressWarnings("unchecked") A...param);
    
    public <K, A>List<K> findEntityList(@SuppressWarnings("unchecked") A...param);

    public <K, A>List<K> findEntityListForPages(A param, PageBounds pageBounds);

    @SuppressWarnings("unchecked")
    public <K, A>K findEntityBySQLId(String sqlId, A...params);
    
    @SuppressWarnings("unchecked")
    public <K, A>List<K> findEntityListBySQLId(String sqlId, A...params);
}