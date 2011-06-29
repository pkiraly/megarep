<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
%><%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean"
%><%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"
%><%@ taglib uri="http://struts.apache.org/tags-html-el"  prefix="html-el"
%><%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"
%><%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="logic-el"
%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>MegaRep</title>
	<link rel="stylesheet" href="css/search.css" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="js/search.js?rand=<% out.write( "" + (new java.util.Random()).nextInt());%>"></script>
</head>
<body>

<h1>.: MegaRep :.</h1>
<p id="changeLocale">
	<a href="changeLocale.do?language=en&path=<bean:write name="searchForm" property="baseURL" />">[ English ]</a>
	<a href="changeLocale.do?language=fr&path=<bean:write name="searchForm" property="baseURL" />">[ French ]</a>
	<a href="changeLocale.do?language=gl&path=<bean:write name="searchForm" property="baseURL" />">[ Galego ]</a>
	<a href="changeLocale.do?language=hu&path=<bean:write name="searchForm" property="baseURL" />">[ Hungarian ]</a>
</p>

<ul id="selectors">
	<li id="search-form-tab">search form</li>
	<li id="results-tab">results</li>
</ul>

<html:form action="/search" method="GET" styleId="main">
<table width="100%">
<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="meter" /></span>
	</td>
	<td>
		<html:select property="meter" styleId="meter"
			onchange="handleMeter(this.options[this.selectedIndex].value)">
			<html:option value=""><bean:message key="select" /></html:option>
			<html:option value="01"><bean:message key="meter.01" /></html:option>
			<html:option value="02"><bean:message key="meter.02" /></html:option>
			<html:option value="03"><bean:message key="meter.03" /></html:option>
			<html:option value="04"><bean:message key="meter.04" /></html:option>
			<html:option value="05"><bean:message key="meter.05" /></html:option>
			<html:option value="06"><bean:message key="meter.06" /></html:option>
			<html:option value="07"><bean:message key="meter.07" /></html:option>
			<html:option value="08"><bean:message key="meter.08" /></html:option>
		</html:select>
		<html:errors property="meter"/><br/>
		<div id="meter-01">
			<fieldset>
				<legend><bean:message key="meter.01" /></legend>

				<html:radio styleId="meter-01-01-01" property="meter_qualifier" value="01-01-01"/>
				<label for="meter-01-01-01"><bean:message key="meter.01.01-01" /></label>
				<br/>

				<html:radio styleId="meter-01-01-02" property="meter_qualifier" value="01-01-02"/>
				<label for="meter-01-01-02"><bean:message key="meter.01.01-02" /></label>
				<br/>

				<html:radio styleId="meter-01-02-01" property="meter_qualifier" value="01-02-01"/>
				<label for="meter-01-02-01"><bean:message key="meter.01.02-01" /></label>
				<br/>

				<html:radio styleId="meter-01-02-02" property="meter_qualifier" value="01-02-02"/>
				<label for="meter-01-02-02"><bean:message key="meter.01.02-02" /></label>
				<br/>

				<html:radio styleId="meter-01-03" property="meter_qualifier" value="01-03"/>
				<label for="meter-01-03"><bean:message key="meter.01.03" /></label>
				<br/>

				<html:radio styleId="meter-01-04" property="meter_qualifier" value="01-04"/>
				<label for="meter-01-04"><bean:message key="meter.01.04" /></label>
	
				<html:errors property="meter_qualifier"/><br/>
			</fieldset>
		</div>

		<div id="meter-07">
			<fieldset>
				<legend><bean:message key="meter.07" /></legend>
				<html:radio styleId="meter-07-01" property="meter_qualifier" value="07-01"/>
				<label for="meter-07-01"><bean:message key="meter.07.01" /></label>
				<br/>

				<html:radio styleId="meter-07-02" property="meter_qualifier" value="07-02"/>
				<label for="meter-07-02"><bean:message key="meter.07.02" /></label>
	
				<html:errors property="meter_qualifier"/><br/>
			</fieldset>
		</div>
	</td>
</tr>

<tr>
<td width="20%">
	<span class="fieldName"><bean:message key="segmentation" /></span>
</td>
<td>
<html:select property="segmentation" 
	onchange="handleSegmentation(this.options[this.selectedIndex].value);" styleId="segmentation">
	<html:option value=""><bean:message key="select" /></html:option>
	<html:option value="01"><bean:message key="segmentation.01" /></html:option>
	<html:option value="02"><bean:message key="segmentation.02" /></html:option>
	<html:option value="03"><bean:message key="segmentation.03" /></html:option>
	<html:option value="04"><bean:message key="segmentation.04" /></html:option>
	<html:option value="05"><bean:message key="segmentation.05" /></html:option>
	<html:option value="06"><bean:message key="segmentation.06" /></html:option>
</html:select>

<div id="segmentation_qualifier">
<fieldset>
	<legend><bean:message key="segmentation.01" /></legend>
	<html:radio styleId="segmentation_qualifier-01" 
		property="segmentation_qualifier" value="01"/>
	<label for="segmentation_qualifier-01"><bean:message 
		key="segmentation.01.01" /></label>
	<br/>

	<html:radio styleId="segmentation_qualifier-02" 
		property="segmentation_qualifier" value="02"/>
	<label for="segmentation_qualifier-02"><bean:message 
		key="segmentation.01.02" /></label>
	
	<html:errors property="segmentation_qualifier"/><br/>
</fieldset>
</div>
</td>
</tr>

<tr>
<td width="20%">
	<span class="fieldName"><bean:message key="rhyme" /></span>
</td>
<td>
	<html:select property="rhyme" onchange="handleRhyme(this.options[this.selectedIndex].value);" 
		styleId="rhyme">
		<html:option value=""><bean:message key="select" /></html:option>
		<html:option value="01"><bean:message key="rhyme.01" /></html:option>
		<html:option value="02"><bean:message key="rhyme.02" /></html:option>
		<html:option value="03"><bean:message key="rhyme.03" /></html:option>
		<html:option value="04"><bean:message key="rhyme.04" /></html:option>
	</html:select>
	<html:errors property="rhyme"/>

<div id="rhyme-01">
<fieldset>
	<legend><bean:message key="rhyme.01" /></legend>
	<html:radio styleId="rhyme-01-01" property="rhyme_qualifier" value="01"/>
	<label for="rhyme-01-01"><bean:message key="rhyme.01.01" /></label>
	<br/>

	<html:radio styleId="rhyme-01-02" property="rhyme_qualifier" value="02"/>
	<label for="rhyme-01-02"><bean:message key="rhyme.01.02" /></label>
	
	<html:errors property="rhyme_qualifier"/>
</fieldset>
</div>

</td>
</tr>

<tr>
<td width="20%">
	<span class="fieldName"><bean:message key="rhyme_scheme" /></span>
</td>
<td>
	<html:text property="rhyme_scheme"/>
	<html:errors property="rhyme_scheme"/>
</td>
</tr>

<tr>
<td width="20%">
	<span class="fieldName"><bean:message key="metrical_scheme" /></span>
</td>
<td>
	<html:text property="metrical_scheme"/>
	<html:errors property="metrical_scheme"/>
</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="declination.line" /></span>
	</td>
	<td>
		<html:select property="declination_line">
			<html:option value=""><bean:message key="select" /></html:option>
			<html:option value="01"><bean:message key="declination.line.01" /></html:option>
			<html:option value="02"><bean:message key="declination.line.02" /></html:option>
			<html:option value="02"><bean:message key="declination.line.03" /></html:option>
		</html:select>
		<html:errors property="declination_line"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="declination.strophe" /></span>
	</td>
	<td>
		<html:select property="declination_strophe">
			<html:option value=""><bean:message key="select" /></html:option>
			<html:option value="01"><bean:message key="declination.strophe.01" /></html:option>
			<html:option value="02"><bean:message key="declination.strophe.02" /></html:option>
		</html:select>
		<html:errors property="declination_strophe"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="declination.scheme" /></span>
	</td>
	<td>
		<html:text property="declination_scheme"/>
		<html:errors property="declination_scheme"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="number_of_lines" /></span>
	</td>
	<td>
		<html:text property="number_of_lines"/>
		<html:errors property="number_of_lines"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="number_of_strophes" /></span>
	</td>
	<td>
		<html:text property="number_of_strophes"/>
		<html:errors property="number_of_strophes"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="author" /></span>
	</td>
	<td>
		<html:text property="author"/>
		<html:errors property="author"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="date" /></span>
	</td>
	<td>
		<html:text property="date"/>
		<html:errors property="date"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="melody" /></span>
	</td>
	<td>
		<html:select property="melody" 
			onchange="handleMelody(this.options[this.selectedIndex].value);" styleId="melody">
			<html:option value=""><bean:message key="select" /></html:option>
			<html:option value="01"><bean:message key="melody.01" /></html:option>
			<html:option value="02"><bean:message key="melody.02" /></html:option>
			<html:option value="03"><bean:message key="melody.03" /></html:option>
		</html:select>
		<html:errors property="melody"/>
		<div id="melody-01">
			<fieldset>
				<legend><bean:message key="language.qualifier" /></legend>
				<html:radio styleId="melody-01-01" property="melody_qualifier" value="01"/>
				<label for="melody-01-01"><bean:message key="melody.01.01" /></label>
				<br/>

				<html:radio styleId="melody-01-02" property="melody_qualifier" value="02"/>
				<label for="melody-01-02"><bean:message key="melody.01.02" /></label>
	
				<html:errors property="melody_qualifier"/>
			</fieldset>
		</div>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="genre" /></span>
	</td>
	<td>
		<html:text property="genre"/>
		<html:errors property="genre"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="caesuras" /></span>
	</td>
	<td>
		<html:text property="caesuras"/>
		<html:errors property="caesuras"/>
	</td>
</tr>

<tr>
<td width="20%">
	<span class="fieldName"><bean:message key="language" /></span>
</td>
<td>
	<html:select property="language" multiple="multiple" size="10" 
		onchange="handleLanguage(this.options);" styleId="language">
	<logic:iterate id="lang" name="searchForm" property="languages"
		><html-el:option value="${lang.key}" 
			><bean:write name="lang" property="value" 
		/> (<bean:write name="lang" property="key" 
		/>)</html-el:option>
	</logic:iterate>
	</html:select>
	<html:errors property="language"/>
	
	<div id="language_qualifier">
		<fieldset>
			<legend><bean:message key="language.qualifier" /></legend>
			<html:radio styleId="language-01" property="language_qualifier" value="01"/>
			<label for="language-01"><bean:message key="language.01" /></label>
			<br/>

			<html:radio styleId="language-02" property="language_qualifier" value="02"/>
			<label for="language-02"><bean:message key="language.02" /></label>
			<br/>

			<html:radio styleId="language-03" property="language_qualifier" value="03"/>
			<label for="language-03"><bean:message key="language.03" /></label>
			<br/>

			<html:radio styleId="language-04" property="language_qualifier" value="04"/>
			<label for="language-04"><bean:message key="language.04" /></label>
	
			<html:errors property="language_qualifier"/>
		</fieldset>
	</div>
</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName">
			<bean:message key="interstrophical_relations" />
			 - <bean:message key="interstrophical_relations.level1" />
		</span>
	</td>
	<td>
		<html:select property="interstrophical_relations_level1" styleId="interstrophical_relations_level1"
			multiple="multiple" size="6">
			<html:option value=""><bean:message key="select" /></html:option>
			<html:option value="01"><bean:message key="interstrophical_relations.level1.01" /></html:option>
			<html:option value="02"><bean:message key="interstrophical_relations.level1.02" /></html:option>
			<html:option value="03"><bean:message key="interstrophical_relations.level1.03" /></html:option>
			<html:option value="04"><bean:message key="interstrophical_relations.level1.04" /></html:option>
			<html:option value="05"><bean:message key="interstrophical_relations.level1.05" /></html:option>
		</html:select>
		<html:errors property="interstrophical_relations_level1"/><br/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName">
			<bean:message key="interstrophical_relations" />
			 - <bean:message key="interstrophical_relations.level1" />
			 - <bean:message key="interstrophical_relations.note" />
		</span>
	</td>
	<td>
		<html:text property="interstrophical_relations_level1_note"></html:text>
		<html:errors property="interstrophical_relations_level1_note"/><br/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName">
			<bean:message key="interstrophical_relations" />
			 - <bean:message key="interstrophical_relations.level2" />
		</span>
	</td>
	<td>
		<html:select property="interstrophical_relations_level2" styleId="interstrophical_relations_level2"
			multiple="multiple" size="10">
			<html:option value=""><bean:message key="select" /></html:option>
			<html:option value="01"><bean:message key="interstrophical_relations.level2.01" /></html:option>
			<html:option value="02"><bean:message key="interstrophical_relations.level2.02" /></html:option>
			<html:option value="03"><bean:message key="interstrophical_relations.level2.03" /></html:option>
			<html:option value="04"><bean:message key="interstrophical_relations.level2.04" /></html:option>
			<html:option value="05"><bean:message key="interstrophical_relations.level2.05" /></html:option>
			<html:option value="06"><bean:message key="interstrophical_relations.level2.06" /></html:option>
			<html:option value="07"><bean:message key="interstrophical_relations.level2.07" /></html:option>
			<html:option value="08"><bean:message key="interstrophical_relations.level2.08" /></html:option>
			<html:option value="09"><bean:message key="interstrophical_relations.level2.09" /></html:option>
			<html:option value="10"><bean:message key="interstrophical_relations.level2.10" /></html:option>
			<html:option value="11"><bean:message key="interstrophical_relations.level2.11" /></html:option>
		</html:select>
		<html:errors property="interstrophical_relations_level2"/><br/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName">
			<bean:message key="interstrophical_relations" />
			 - <bean:message key="interstrophical_relations.level2" />
			 - <bean:message key="interstrophical_relations.note" />
		</span>
	</td>
	<td>
		<html:text property="interstrophical_relations_level1_note"></html:text>
		<html:errors property="interstrophical_relations_level1_note"/><br/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="refrain" /></span>
	</td>
	<td>
		<html:select property="refrain" 
			onchange="handleRefrain(this.options[this.selectedIndex].value);" styleId="refrain">
			<html:option value=""><bean:message key="select" /></html:option>
			<html:option value="01"><bean:message key="refrain.01" /></html:option>
			<html:option value="02"><bean:message key="refrain.02" /></html:option>
		</html:select>
		<html:errors property="refrain"/>
		<div id="refrain_qualifier">
			<fieldset>
				<legend><bean:message key="refrain.02" /></legend>
				<html:radio styleId="refrain-01-01" property="refrain_qualifier" value="01-01"/>
				<label for="refrain-02-01"><bean:message key="refrain.02.01-01" /></label>
				<br/>

				<html:radio styleId="refrain-01-02" property="refrain_qualifier" value="01-02"/>
				<label for="refrain-01-02"><bean:message key="refrain.02.01-02" /></label>
				<br/>

				<html:radio styleId="refrain-02-01" property="refrain_qualifier" value="02-01"/>
				<label for="refrain-02-01"><bean:message key="refrain.02.02-01" /></label>
				<br/>

				<html:radio styleId="refrain-02-02" property="refrain_qualifier" value="02-02"/>
				<label for="refrain-02-02"><bean:message key="refrain.02.02-02" /></label>
				<br/>

				<html:radio styleId="refrain-02-03" property="refrain_qualifier" value="02-03"/>
				<label for="refrain-02-03"><bean:message key="refrain.02.02-03" /></label>
				<br/>

				<html:errors property="refrain_qualifier"/>
			</fieldset>
		</div>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="interior_generic_designation" /></span>
	</td>
	<td>
		<html:text property="interior_generic_designation"/>
		<html:errors property="interior_generic_designation"/>
	</td>
</tr>

<tr>
	<td width="20%">
		<span class="fieldName"><bean:message key="exterior_contemporary_generic_designation" /></span>
	</td>
	<td>
		<html:text property="exterior_contemporary_generic_designation"/>
		<html:errors property="exterior_contemporary_generic_designation"/>
	</td>
</tr>

<tr>
	<td width="20%"></td>
	<td><html:submit value="OK" /><html:cancel/></td>
</tr>
</table>
</html:form>

<div id="results">
<p>
	Query: <span id="query"><bean:write name="searchForm" property="query" filter="false" /></span>,
	found <bean:write name="searchForm" property="totalResults" /> records, 
	displayed 
	<bean:write name="searchForm" property="startIndex" />-<bean:write name="searchForm" property="endIndex" />
	records
	from <bean:write name="searchForm" property="servers" />.
</p>
<p><bean:write name="searchForm" property="navigationLine" filter="false" /></p>

<bean:write name="searchForm" property="results" filter="false" />
<p id="error"><bean:write name="searchForm" property="error" /></p>
</div>

</body>
</html>
