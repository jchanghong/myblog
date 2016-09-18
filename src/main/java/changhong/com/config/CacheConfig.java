package changhong.com.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Cache could be disable in unit test.
 */
@Configuration
@EnableCaching
@Profile("production")
public class CacheConfig {

	// @Bean
	// public JCacheManagerCustomizer cacheManagerCustomizer() {
	// return new JCacheManagerCustomizer() {
	// @Override
	// public void customize(CacheManager cacheManager) {
	// CacheConfiguration<Object, Object> config = CacheConfigurationBuilder
	// .newCacheConfigurationBuilder(Object.class, Object.class,
	// ResourcePoolsBuilder.newResourcePoolsBuilder()
	// .heap(100, EntryUnit.ENTRIES))
	// .withExpiry(Expirations.timeToLiveExpiration(Duration.of(60,
	// TimeUnit.SECONDS)))
	// .build();
	// cacheManager.createCache("vets",
	// Eh107Configuration.fromEhcacheCacheConfiguration(config));
	// }
	// };
	// }

}
