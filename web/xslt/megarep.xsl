<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
                xmlns:mr="http://www.megarep.org"
                xmlns:rpha="http://tesuji.eu/rpha"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:php="http://php.net/xsl"
                exclude-result-prefixes="php">

<xsl:output method="html" indent="yes" encoding="utf-8" omit-xml-declaration="yes" />

<xsl:param name="lang" select="'hu'" />
<xsl:param name="xsltDir" select="''" />
<xsl:param name="startIndex" select="1" />

<xsl:variable name="doc" select="concat($xsltDir, '/language.', $lang, '.xml')" />

<xsl:template match="/">
	<xsl:for-each select="rss/channel/item">
		<xsl:apply-templates select="." />
	</xsl:for-each>
</xsl:template>

<xsl:template match="item">
	<div>
		<xsl:value-of select="count(preceding-sibling::item) + number($startIndex)" />
		<xsl:text>.) </xsl:text>
		<a>
			<xsl:attribute name="href" select="link" />
			
			<xsl:if test="description/mr:record/mr:author
			              and string-length(description/mr:record/mr:author) &gt; 0">
				<xsl:value-of select="description/mr:record/mr:author" />
				<xsl:text>: </xsl:text>
			</xsl:if>

			<xsl:if test="description/mr:record/mr:title
			              and string-length(description/mr:record/mr:title) &gt; 0">
				<xsl:value-of select="description/mr:record/mr:title" />
			</xsl:if>

			<xsl:if test="description/mr:record/mr:incipit
			              and string-length(description/mr:record/mr:incipit) &gt; 0">
				<xsl:text> (</xsl:text>
				<i>
					<xsl:text>&#x00AB;</xsl:text>
					<xsl:value-of select="description/mr:record/mr:incipit" />
					<xsl:text>&#x2026;</xsl:text>
					<xsl:text>&#x00BB;</xsl:text>
				</i>
				<xsl:text>)</xsl:text>
			</xsl:if>

			<xsl:if test="description/mr:record/mr:id">
				<xsl:text> [ID:</xsl:text>
				<xsl:value-of select="description/mr:record/mr:id" />
				<xsl:text>]</xsl:text>
			</xsl:if>
		</a>
		<br/>
		
		<xsl:if test="description/mr:record/mr:language
			and string-length(description/mr:record/mr:language) &gt; 0">
			<i><xsl:value-of select="document($doc)/keys/key[@id = 'language']/text()" /></i>
			<xsl:text>: </xsl:text>
			<xsl:for-each select="description/mr:record/mr:language">
				<xsl:if test="position() > 1">, </xsl:if>
				<xsl:value-of select="." />
			</xsl:for-each>
			<br/>
		</xsl:if>

		<xsl:if test="description/mr:record/mr:caesuras
			and string-length(description/mr:record/mr:caesuras) &gt; 0">
			<i><xsl:value-of select="document($doc)/keys/key[@id = 'caesuras']/text()" /></i>
			<xsl:text>: </xsl:text>
			<xsl:value-of select="description/mr:record/mr:caesuras" />
			<br/>
		</xsl:if>

		<xsl:if test="description/mr:record/mr:date
			 and string-length(description/mr:record/mr:date) &gt; 0">
			<i><xsl:value-of select="document($doc)/keys/key[@id = 'date']/text()" /></i>
			<xsl:text>: </xsl:text>
			<xsl:value-of select="description/mr:record/mr:date" />
			<xsl:if test="description/mr:record/mr:date_qualifier">
				<xsl:text> (</xsl:text>
				<xsl:value-of select="description/mr:record/mr:date_qualifier" />
				<xsl:text>)</xsl:text>
			</xsl:if>
			<br/>
		</xsl:if>

		<xsl:if test="description/mr:record/mr:melody
			and string-length(description/mr:record/mr:melody) &gt; 0">
			<i><xsl:value-of select="document($doc)/keys/key[@id = 'melody']/text()" /></i>
			<xsl:text>: </xsl:text>
			<xsl:variable name="key" select="concat('melody.', description/mr:record/mr:melody)" />
			<xsl:value-of select="document($doc)/keys/key[@id = $key]/text()" />
			<br/>
		</xsl:if>

		<xsl:if test="description/mr:record/mr:genre
			and (count(description/mr:record/mr:genre) &gt; 1 or
				(count(description/mr:record/mr:genre) = 1
				and string-length(description/mr:record/mr:genre) > 0))">
			<i>
			  <xsl:value-of select="document($doc)/keys/key[@id = 'genre']/text()" />
			</i>
			<xsl:text>: </xsl:text>
			<xsl:value-of select="description/mr:record/mr:genre" />
			<br/>
		</xsl:if>

		<xsl:if test="(description/mr:record/mr:number_of_lines 
			and string-length(description/mr:record/mr:number_of_lines) &gt; 0)
			or (description/mr:record/mr:number_of_strophes
			and string-length(description/mr:record/mr:number_of_strophes) &gt; 0)">
			<xsl:if test="description/mr:record/mr:number_of_lines
			              and string-length(description/mr:record/mr:number_of_lines) &gt; 0">
				<i><xsl:value-of select="document($doc)/keys/key[@id = 'number_of_lines']/text()" /></i>
				<xsl:text>: </xsl:text>
				<xsl:for-each select="description/mr:record/mr:number_of_lines">
					<xsl:if test="position() > 1">, </xsl:if>
					<xsl:value-of select="." />
				</xsl:for-each>
			</xsl:if>

			<xsl:if test="description/mr:record/mr:number_of_lines 
			and string-length(description/mr:record/mr:number_of_lines) &gt; 0
			and description/mr:record/mr:number_of_strophes
			and string-length(description/mr:record/mr:number_of_strophes) &gt; 0">
				<xsl:text>, </xsl:text>
			</xsl:if>

			<xsl:if test="description/mr:record/mr:number_of_strophes
				and string-length(description/mr:record/mr:number_of_strophes) &gt; 0">
				<i><xsl:value-of select="document($doc)/keys/key[@id = 'number_of_strophes']/text()" /></i>
				<xsl:text>: </xsl:text>
				<xsl:for-each select="description/mr:record/mr:number_of_strophes">
					<xsl:if test="position() > 1">, </xsl:if>
					<xsl:value-of select="." />
				</xsl:for-each>
			</xsl:if>
			<br/>
		</xsl:if>

		<xsl:if test="description/mr:record/mr:meter
			and string-length(description/mr:record/mr:meter) &gt; 0">
			<i><xsl:value-of select="document($doc)/keys/key[@id = 'meter']/text()" /></i>
			<xsl:text>: </xsl:text>
			<xsl:variable name="key" select="concat('meter.', description/mr:record/mr:meter)" />
			<xsl:value-of select="document($doc)/keys/key[@id = $key]/text()" />
			<br/>
		</xsl:if>

		<xsl:if test="description/mr:record/mr:rhyme_scheme 
			and string-length(description/mr:record/mr:rhyme_scheme) &gt; 0">
			<i><xsl:value-of select="document($doc)/keys/key[@id = 'rhyme_scheme']/text()" /></i>
			<xsl:text>: </xsl:text>
			<xsl:value-of select="description/mr:record/mr:rhyme_scheme" />
			<br/>
		</xsl:if>

		<xsl:if test="description/mr:record/mr:metrical_scheme
			and string-length(description/mr:record/mr:metrical_scheme) &gt; 0">
			<i><xsl:value-of select="document($doc)/keys/key[@id = 'metrical_scheme']/text()" /></i>
			<xsl:text>: </xsl:text>
			<xsl:value-of select="description/mr:record/mr:metrical_scheme" />
			<br/>
		</xsl:if>
	</div>
</xsl:template>

</xsl:stylesheet>