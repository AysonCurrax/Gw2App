package gw2.api.json.utility;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"item_id","name","description","type","level","rarity","vendor_value","icon_file_id","icon_file_signature","default_skin","game_types","flags","restrictions","armor","back","bag","consumable","container","gathering","gizmo","tool","trinket","upgrade_component","weapon"})
public class ItemJSONObject {

	@JsonPropertyOrder({"skill_id","description"})
	public static class Buff {
		
		@JsonProperty("skill_id")
		private String skillId;

		@JsonProperty("description")
		private String description;

		public String getSkillId() {
			return skillId;
		}

		public void setSkillId(String skillId) {
			this.skillId = skillId;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}

	@JsonPropertyOrder({"attribute","modifier"})
	public static class Attribute {
		
		@JsonProperty("attribute")
		private String attribute;

		@JsonProperty("modifier")
		private String modifier;

		public String getAttribute() {
			return attribute;
		}

		public void setAttribute(String attribute) {
			this.attribute = attribute;
		}

		public String getModifier() {
			return modifier;
		}

		public void setModifier(String modifier) {
			this.modifier = modifier;
		}
	}

	@JsonPropertyOrder({"buff","attributes"})
	public static class InfixUpgrade {
		
		@JsonProperty("buff")
		private Buff buff;

		@JsonProperty("attributes")
		private List<Attribute> attributes;

		public Buff getBuff() {
			return buff;
		}

		public void setBuff(Buff buff) {
			this.buff = buff;
		}

		public List<Attribute> getAttributes() {
			return attributes;
		}

		public void setAttributes(List<Attribute> attributes) {
			this.attributes = attributes;
		}
	}

	public static class BaseInfusionSlot {
		
		@JsonProperty("flags")
		private List<String> flags;

		public List<String> getFlags() {
			return flags;
		}

		public void setFlags(List<String> flags) {
			this.flags = flags;
		}
	}

	@JsonPropertyOrder({"item_id","flags"})
	public static class ExtendedInfusionSlot extends BaseInfusionSlot {
		
		@JsonProperty("item_id")
		private String itemId;

		public String getItemid() {
			return itemId;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
	}

	@JsonPropertyOrder({"type","weight_class","defense","infusion_slots","infix_upgrade","suffix_item_id","secondary_suffix_item_id"})
	public static class Armor {
		
		@JsonProperty("type")
		private String type;

		@JsonProperty("weight_class")
		private String weightClass;

		@JsonProperty("defense")
		private String defense;

		@JsonProperty("infusion_slots")
		private List<BaseInfusionSlot> infusionSlots;

		@JsonProperty("infix_upgrade")
		private InfixUpgrade infixUpgrade;

		@JsonProperty("suffix_item_id")
		private String suffixItemId;

		@JsonProperty("secondary_suffix_item_id")
		private String secondarySuffixItemId;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getWeightClass() {
			return weightClass;
		}

		public void setWeightClass(String weightClass) {
			this.weightClass = weightClass;
		}

		public String getDefense() {
			return defense;
		}

		public void setDefense(String defense) {
			this.defense = defense;
		}

		public List<BaseInfusionSlot> getInfusionSlots() {
			return infusionSlots;
		}

		public void setInfusionSlots(List<BaseInfusionSlot> infusionSlots) {
			this.infusionSlots = infusionSlots;
		}

		public InfixUpgrade getInfixUpgrade() {
			return infixUpgrade;
		}

		public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
			this.infixUpgrade = infixUpgrade;
		}

		public String getSuffixItemId() {
			return suffixItemId;
		}

		public void setSuffixItemId(String suffixItemId) {
			this.suffixItemId = suffixItemId;
		}

		public String getSecondarySuffixItemId() {
			return secondarySuffixItemId;
		}

		public void setSecondarySuffixItemId(String secondarySuffixItemId) {
			this.secondarySuffixItemId = secondarySuffixItemId;
		}
	}

	@JsonPropertyOrder({"infusion_slots","infix_upgrade","suffix_item_id","secondary_suffix_item_id"})
	public static class Back {
		
		@JsonProperty("infusion_slots")
		private List<ExtendedInfusionSlot> infusionSlots;

		@JsonProperty("infix_upgrade")
		private InfixUpgrade infixUpgrade;

		@JsonProperty("suffix_item_id")
		private String suffixItemId;

		@JsonProperty("secondary_suffix_item_id")
		private String secondarySuffixItemId;

		public List<ExtendedInfusionSlot> getInfusionSlots() {
			return infusionSlots;
		}

		public void setInfusionSlots(List<ExtendedInfusionSlot> infusionSlots) {
			this.infusionSlots = infusionSlots;
		}

		public InfixUpgrade getInfixUpgrade() {
			return infixUpgrade;
		}

		public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
			this.infixUpgrade = infixUpgrade;
		}

		public String getSuffixItemId() {
			return suffixItemId;
		}

		public void setSuffixItemId(String suffixItemId) {
			this.suffixItemId = suffixItemId;
		}

		public String getSecondarySuffixItemId() {
			return secondarySuffixItemId;
		}

		public void setSecondarySuffixItemId(String secondarySuffixItemId) {
			this.secondarySuffixItemId = secondarySuffixItemId;
		}
	}

	@JsonPropertyOrder({"no_sell_or_sort","size"})
	public static class Bag {
		
		@JsonProperty("no_sell_or_sort")
		private String noSellOrSort;

		@JsonProperty("size")
		private String size;

		public String getNoSellOrSort() {
			return noSellOrSort;
		}

		public void setNoSellOrSort(String noSellOrSort) {
			this.noSellOrSort = noSellOrSort;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}
	}

	@JsonPropertyOrder({"type","duration_ms","description","unlock_type","recipe_id","color_id"})
	public static class Consumable {
		
		@JsonProperty("type")
		private String type;

		@JsonProperty("duration_ms")
		private String durationMs;

		@JsonProperty("description")
		private String description;

		@JsonProperty("unlock_type")
		private String unlockType;

		@JsonProperty("recipe_id")
		private String recipeId;

		@JsonProperty("color_id")
		private String colorId;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDurationMs() {
			return durationMs;
		}

		public void setDurationMs(String durationMs) {
			this.durationMs = durationMs;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getUnlockType() {
			return unlockType;
		}

		public void setUnlockType(String unlockType) {
			this.unlockType = unlockType;
		}

		public String getRecipeId() {
			return recipeId;
		}

		public void setRecipeId(String recipeId) {
			this.recipeId = recipeId;
		}

		public String getColorId() {
			return colorId;
		}

		public void setColorId(String colorId) {
			this.colorId = colorId;
		}
	}

	public static class Container {
		
		@JsonProperty("type")
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	public static class Gathering {
		
		@JsonProperty("type")
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	public static class Gizmo {
		
		@JsonProperty("type")
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	@JsonPropertyOrder({"type","charges"})
	public static class Tool {
		
		@JsonProperty("type")
		private String type;

		@JsonProperty("charges")
		private String charges;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCharges() {
			return charges;
		}

		public void setCharges(String charges) {
			this.charges = charges;
		}
	}

	@JsonPropertyOrder({"type","infusion_slots","infix_upgrade","suffix_item_id","secondary_suffix_item_id"})
	public static class Trinket {
		
		@JsonProperty("type")
		private String type;

		@JsonProperty("infusion_slots")
		private List<ExtendedInfusionSlot> infusionSlots;

		@JsonProperty("infix_upgrade")
		private InfixUpgrade infixUpgrade;

		@JsonProperty("suffix_item_id")
		private String suffixItemId;

		@JsonProperty("secondary_suffix_item_id")
		private String secondarySuffixItemId;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<ExtendedInfusionSlot> getInfusionSlots() {
			return infusionSlots;
		}

		public void setInfusionSlots(List<ExtendedInfusionSlot> infusionSlots) {
			this.infusionSlots = infusionSlots;
		}

		public InfixUpgrade getInfixUpgrade() {
			return infixUpgrade;
		}

		public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
			this.infixUpgrade = infixUpgrade;
		}

		public String getSuffixItemId() {
			return suffixItemId;
		}

		public void setSuffixItemId(String suffixItemId) {
			this.suffixItemId = suffixItemId;
		}

		public String getSecondarySuffixItemId() {
			return secondarySuffixItemId;
		}

		public void setSecondarySuffixItemId(String secondarySuffixItemId) {
			this.secondarySuffixItemId = secondarySuffixItemId;
		}
	}

	@JsonPropertyOrder({"type","flags","infusion_upgrade_flags","infix_upgrade","suffix"})
	public static class UpgradeComponent {
		
		@JsonProperty("type")
		private String type;

		@JsonProperty("flags")
		private List<String> flags;

		@JsonProperty("infusion_upgrade_flags")
		private List<String> infusionUpgradeFlags;

		@JsonProperty("infix_upgrade")
		private InfixUpgrade infixUpgrade;

		@JsonProperty("suffix")
		private String suffix;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<String> getFlags() {
			return flags;
		}

		public void setFlags(List<String> flags) {
			this.flags = flags;
		}

		public List<String> getInfusionUpgradeFlags() {
			return infusionUpgradeFlags;
		}

		public void setInfusionUpgradeFlags(List<String> infusionUpgradeFlags) {
			this.infusionUpgradeFlags = infusionUpgradeFlags;
		}

		public InfixUpgrade getInfixUpgrade() {
			return infixUpgrade;
		}

		public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
			this.infixUpgrade = infixUpgrade;
		}

		public String getSuffix() {
			return suffix;
		}

		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
	}

	@JsonPropertyOrder({"type","damage_type","min_power","max_power","defense","infusion_slots","infix_upgrade","suffix_item_id","secondary_suffix_item_id"})
	public static class Weapon {
		
		@JsonProperty("type")
		private String type;

		@JsonProperty("damage_type")
		private String damageType;

		@JsonProperty("min_power")
		private String minPower;

		@JsonProperty("max_power")
		private String maxPower;

		@JsonProperty("defense")
		private String defense;

		@JsonProperty("infusion_slots")
		private List<BaseInfusionSlot> infusionSlots;

		@JsonProperty("infix_upgrade")
		private InfixUpgrade infixUpgrade;

		@JsonProperty("suffix_item_id")
		private String suffixItemId;

		@JsonProperty("secondary_suffix_item_id")
		private String secondarySuffixItemId;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDamageType() {
			return damageType;
		}

		public void setDamageType(String damageType) {
			this.damageType = damageType;
		}

		public String getMinPower() {
			return minPower;
		}

		public void setMinPower(String minPower) {
			this.minPower = minPower;
		}

		public String getMaxPower() {
			return maxPower;
		}

		public void setMaxPower(String maxPower) {
			this.maxPower = maxPower;
		}

		public String getDefense() {
			return defense;
		}

		public void setDefense(String defense) {
			this.defense = defense;
		}

		public List<BaseInfusionSlot> getInfusionSlots() {
			return infusionSlots;
		}

		public void setInfusionSlots(List<BaseInfusionSlot> infusionSlots) {
			this.infusionSlots = infusionSlots;
		}

		public InfixUpgrade getInfixUpgrade() {
			return infixUpgrade;
		}

		public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
			this.infixUpgrade = infixUpgrade;
		}

		public String getSuffixItemId() {
			return suffixItemId;
		}

		public void setSuffixItemId(String suffixItemId) {
			this.suffixItemId = suffixItemId;
		}

		public String getSecondarySuffixItemId() {
			return secondarySuffixItemId;
		}

		public void setSecondarySuffixItemId(String secondarySuffixItemid) {
			this.secondarySuffixItemId = secondarySuffixItemid;
		}
	}

	@JsonProperty("item_id")
	private String itemId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("level")
	private String level;
	
	@JsonProperty("rarity")
	private String rarity;
	
	@JsonProperty("vendor_value")
	private String vendorValue;
	
	@JsonProperty("icon_file_id")
	private String iconFileId;
	
	@JsonProperty("icon_file_signature")
	private String iconFileSignature;
	
	@JsonProperty("default_skin")
	private String defaultSkin;
	
	@JsonProperty("game_types")
	private List<String> gameTypes;
	
	@JsonProperty("flags")
	private List<String> flags;
	
	@JsonProperty("restrictions")
	private List<String> restrictions;
	
	@JsonProperty("armor")
	private Armor armor;
	
	@JsonProperty("back")
	private Back back;
	
	@JsonProperty("bag")
	private Bag bag;
	
	@JsonProperty("consumable")
	private Consumable consumable;
	
	@JsonProperty("container")
	private Container container;
	
	@JsonProperty("gathering")
	private Gathering gathering;
	
	@JsonProperty("gizmo")
	private Gizmo gizmo;
	
	@JsonProperty("tool")
	private Tool tool;
	
	@JsonProperty("trinket")
	private Trinket trinket;
	
	@JsonProperty("upgrade_component")
	private UpgradeComponent upgradeComponent;
	
	@JsonProperty("weapon")
	private Weapon weapon;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getVendorValue() {
		return vendorValue;
	}

	public void setVendorValue(String vendorValue) {
		this.vendorValue = vendorValue;
	}

	public String getIconFileId() {
		return iconFileId;
	}

	public void setIconFileId(String iconFileId) {
		this.iconFileId = iconFileId;
	}

	public String getIconFileSignature() {
		return iconFileSignature;
	}

	public void setIconFileSignature(String iconFileSignature) {
		this.iconFileSignature = iconFileSignature;
	}

	public String getDefaultSkin() {
		return defaultSkin;
	}

	public void setDefaultSkin(String defaultSkin) {
		this.defaultSkin = defaultSkin;
	}

	public List<String> getGameTypes() {
		return gameTypes;
	}

	public void setGameTypes(List<String> gameTypes) {
		this.gameTypes = gameTypes;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public List<String> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(List<String> restrictions) {
		this.restrictions = restrictions;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Back getBack() {
		return back;
	}

	public void setBack(Back back) {
		this.back = back;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}

	public Consumable getConsumable() {
		return consumable;
	}

	public void setConsumable(Consumable consumable) {
		this.consumable = consumable;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Gathering getGathering() {
		return gathering;
	}

	public void setGathering(Gathering gathering) {
		this.gathering = gathering;
	}

	public Gizmo getGizmo() {
		return gizmo;
	}

	public void setGizmo(Gizmo gizmo) {
		this.gizmo = gizmo;
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public Trinket getTrinket() {
		return trinket;
	}

	public void setTrinket(Trinket trinket) {
		this.trinket = trinket;
	}

	public UpgradeComponent getUpgradeComponent() {
		return upgradeComponent;
	}

	public void setUpgradeComponent(UpgradeComponent upgradeComponent) {
		this.upgradeComponent = upgradeComponent;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
