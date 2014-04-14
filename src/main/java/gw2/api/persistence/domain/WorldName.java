package gw2.api.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import gw2.api.persistence.domain.WorldName.WorldNameId;

@Entity
@IdClass(value = WorldNameId.class)
@Table(name = "world_names")
public class WorldName {

	public static class WorldNameId implements Serializable{
		private static final long serialVersionUID = 8222581167991435039L;
		private String id;
		private String lang;
		
		public WorldNameId() {	
		}
		
		public WorldNameId(String id, String lang) {
			this.id = id;
			this.lang = lang;
		}
		
		@Override
		public int hashCode() {
			HashCodeBuilder builder = new HashCodeBuilder();
			builder.append(this.id);
			builder.append(this.lang);
			return builder.toHashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if ( (obj == null) || !(obj instanceof WorldNameId) ) {
				return false;
			}
			WorldNameId other = (WorldNameId) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.id, other.id);
			builder.append(this.lang, other.lang);
			return builder.isEquals();
		}
	}
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Id
	@Column(name = "lang")
	private String lang;
	
	@Column(name = "name")
	private String name;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLang() {
		return lang;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
