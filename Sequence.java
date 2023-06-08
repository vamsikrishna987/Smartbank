package com.pack.model;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class Sequence extends SequenceStyleGenerator{
	public static final String PREFIX1 = "valuePrefix";
	public static final String PREFIXDEFAULT1 = "";
  
	private String valuePrefix;
	public static final String NUMBERFORMAT1="numerFormat";
	public static final String NUMBERDEFAULT1 = "%d";
	 private String numberFormat;
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		valuePrefix=ConfigurationHelper.getString(PREFIX1, params,PREFIXDEFAULT1);
		numberFormat=ConfigurationHelper.getString(NUMBERDEFAULT1, params,NUMBERDEFAULT1);
		
	}
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return valuePrefix +String.format(numberFormat,super.generate(session, object));
	}
	 
	 
}
