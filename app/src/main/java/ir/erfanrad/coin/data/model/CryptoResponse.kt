package ir.erfanrad.coin.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoResponse(
    @SerialName("Data")
    val `data`: List<Data>,
    @SerialName("HasWarning")
    val hasWarning: Boolean,
    @SerialName("Message")
    val message: String,
    @SerialName("MetaData")
    val metaData: MetaData,
    @SerialName("RateLimit")
    val rateLimit: RateLimit,
    @SerialName("Type")
    val type: Int
) {
    @Serializable
    data class Data(
        @SerialName("CoinInfo")
        val coinInfo: CoinInfo,
        @SerialName("DISPLAY")
        val dISPLAY: DISPLAY,
        @SerialName("RAW")
        val rAW: RAW
    ) {
        @Serializable
        data class CoinInfo(
            @SerialName("Algorithm")
            val algorithm: String,
            @SerialName("AssetLaunchDate")
            val assetLaunchDate: String,
            @SerialName("BlockNumber")
            val blockNumber: Int,
            @SerialName("BlockReward")
            val blockReward: Double,
            @SerialName("BlockTime")
            val blockTime: Double,
            @SerialName("DocumentType")
            val documentType: String,
            @SerialName("FullName")
            val fullName: String,
            @SerialName("Id")
            val id: String,
            @SerialName("ImageUrl")
            val imageUrl: String,
            @SerialName("Internal")
            val `internal`: String,
            @SerialName("MaxSupply")
            val maxSupply: Double,
            @SerialName("Name")
            val name: String,
            @SerialName("NetHashesPerSecond")
            val netHashesPerSecond: Long,
            @SerialName("ProofType")
            val proofType: String,
            @SerialName("Rating")
            val rating: Rating,
            @SerialName("Type")
            val type: Int,
            @SerialName("Url")
            val url: String
        ) {
            @Serializable
            data class Rating(
                @SerialName("Weiss")
                val weiss: Weiss
            ) {
                @Serializable
                data class Weiss(
                    @SerialName("MarketPerformanceRating")
                    val marketPerformanceRating: String,
                    @SerialName("Rating")
                    val rating: String,
                    @SerialName("TechnologyAdoptionRating")
                    val technologyAdoptionRating: String
                )
            }
        }

        @Serializable
        data class DISPLAY(
            @SerialName("USD")
            val uSD: USD
        ) {
            @Serializable
            data class USD(
                @SerialName("CHANGE24HOUR")
                val cHANGE24HOUR: String,
                @SerialName("CHANGEDAY")
                val cHANGEDAY: String,
                @SerialName("CHANGEHOUR")
                val cHANGEHOUR: String,
                @SerialName("CHANGEPCT24HOUR")
                val cHANGEPCT24HOUR: String,
                @SerialName("CHANGEPCTDAY")
                val cHANGEPCTDAY: String,
                @SerialName("CHANGEPCTHOUR")
                val cHANGEPCTHOUR: String,
                @SerialName("CIRCULATINGSUPPLY")
                val cIRCULATINGSUPPLY: String,
                @SerialName("CIRCULATINGSUPPLYMKTCAP")
                val cIRCULATINGSUPPLYMKTCAP: String,
                @SerialName("CONVERSIONLASTUPDATE")
                val cONVERSIONLASTUPDATE: String,
                @SerialName("CONVERSIONSYMBOL")
                val cONVERSIONSYMBOL: String,
                @SerialName("CONVERSIONTYPE")
                val cONVERSIONTYPE: String,
                @SerialName("FROMSYMBOL")
                val fROMSYMBOL: String,
                @SerialName("HIGH24HOUR")
                val hIGH24HOUR: String,
                @SerialName("HIGHDAY")
                val hIGHDAY: String,
                @SerialName("HIGHHOUR")
                val hIGHHOUR: String,
                @SerialName("IMAGEURL")
                val iMAGEURL: String,
                @SerialName("LASTMARKET")
                val lASTMARKET: String,
                @SerialName("LASTTRADEID")
                val lASTTRADEID: String,
                @SerialName("LASTUPDATE")
                val lASTUPDATE: String,
                @SerialName("LASTVOLUME")
                val lASTVOLUME: String,
                @SerialName("LASTVOLUMETO")
                val lASTVOLUMETO: String,
                @SerialName("LOW24HOUR")
                val lOW24HOUR: String,
                @SerialName("LOWDAY")
                val lOWDAY: String,
                @SerialName("LOWHOUR")
                val lOWHOUR: String,
                @SerialName("MARKET")
                val mARKET: String,
                @SerialName("MKTCAP")
                val mKTCAP: String,
                @SerialName("MKTCAPPENALTY")
                val mKTCAPPENALTY: String,
                @SerialName("OPEN24HOUR")
                val oPEN24HOUR: String,
                @SerialName("OPENDAY")
                val oPENDAY: String,
                @SerialName("OPENHOUR")
                val oPENHOUR: String,
                @SerialName("PRICE")
                val pRICE: String,
                @SerialName("SUPPLY")
                val sUPPLY: String,
                @SerialName("TOPTIERVOLUME24HOUR")
                val tOPTIERVOLUME24HOUR: String,
                @SerialName("TOPTIERVOLUME24HOURTO")
                val tOPTIERVOLUME24HOURTO: String,
                @SerialName("TOSYMBOL")
                val tOSYMBOL: String,
                @SerialName("TOTALTOPTIERVOLUME24H")
                val tOTALTOPTIERVOLUME24H: String,
                @SerialName("TOTALTOPTIERVOLUME24HTO")
                val tOTALTOPTIERVOLUME24HTO: String,
                @SerialName("TOTALVOLUME24H")
                val tOTALVOLUME24H: String,
                @SerialName("TOTALVOLUME24HTO")
                val tOTALVOLUME24HTO: String,
                @SerialName("VOLUME24HOUR")
                val vOLUME24HOUR: String,
                @SerialName("VOLUME24HOURTO")
                val vOLUME24HOURTO: String,
                @SerialName("VOLUMEDAY")
                val vOLUMEDAY: String,
                @SerialName("VOLUMEDAYTO")
                val vOLUMEDAYTO: String,
                @SerialName("VOLUMEHOUR")
                val vOLUMEHOUR: String,
                @SerialName("VOLUMEHOURTO")
                val vOLUMEHOURTO: String
            )
        }

        @Serializable
        data class RAW(
            @SerialName("USD")
            val uSD: USD
        ) {
            @Serializable
            data class USD(
                @SerialName("CHANGE24HOUR")
                val cHANGE24HOUR: Double,
                @SerialName("CHANGEDAY")
                val cHANGEDAY: Double,
                @SerialName("CHANGEHOUR")
                val cHANGEHOUR: Double,
                @SerialName("CHANGEPCT24HOUR")
                val cHANGEPCT24HOUR: Double,
                @SerialName("CHANGEPCTDAY")
                val cHANGEPCTDAY: Double,
                @SerialName("CHANGEPCTHOUR")
                val cHANGEPCTHOUR: Double,
                @SerialName("CIRCULATINGSUPPLY")
                val cIRCULATINGSUPPLY: Double,
                @SerialName("CIRCULATINGSUPPLYMKTCAP")
                val cIRCULATINGSUPPLYMKTCAP: Double,
                @SerialName("CONVERSIONLASTUPDATE")
                val cONVERSIONLASTUPDATE: Int,
                @SerialName("CONVERSIONSYMBOL")
                val cONVERSIONSYMBOL: String,
                @SerialName("CONVERSIONTYPE")
                val cONVERSIONTYPE: String,
                @SerialName("FLAGS")
                val fLAGS: String,
                @SerialName("FROMSYMBOL")
                val fROMSYMBOL: String,
                @SerialName("HIGH24HOUR")
                val hIGH24HOUR: Double,
                @SerialName("HIGHDAY")
                val hIGHDAY: Double,
                @SerialName("HIGHHOUR")
                val hIGHHOUR: Double,
                @SerialName("IMAGEURL")
                val iMAGEURL: String,
                @SerialName("LASTMARKET")
                val lASTMARKET: String,
                @SerialName("LASTTRADEID")
                val lASTTRADEID: String,
                @SerialName("LASTUPDATE")
                val lASTUPDATE: Int,
                @SerialName("LASTVOLUME")
                val lASTVOLUME: Double,
                @SerialName("LASTVOLUMETO")
                val lASTVOLUMETO: Double,
                @SerialName("LOW24HOUR")
                val lOW24HOUR: Double,
                @SerialName("LOWDAY")
                val lOWDAY: Double,
                @SerialName("LOWHOUR")
                val lOWHOUR: Double,
                @SerialName("MARKET")
                val mARKET: String,
                @SerialName("MEDIAN")
                val mEDIAN: Double,
                @SerialName("MKTCAP")
                val mKTCAP: Double,
                @SerialName("MKTCAPPENALTY")
                val mKTCAPPENALTY: Int,
                @SerialName("OPEN24HOUR")
                val oPEN24HOUR: Double,
                @SerialName("OPENDAY")
                val oPENDAY: Double,
                @SerialName("OPENHOUR")
                val oPENHOUR: Double,
                @SerialName("PRICE")
                val pRICE: Double,
                @SerialName("SUPPLY")
                val sUPPLY: Double,
                @SerialName("TOPTIERVOLUME24HOUR")
                val tOPTIERVOLUME24HOUR: Double,
                @SerialName("TOPTIERVOLUME24HOURTO")
                val tOPTIERVOLUME24HOURTO: Double,
                @SerialName("TOSYMBOL")
                val tOSYMBOL: String,
                @SerialName("TOTALTOPTIERVOLUME24H")
                val tOTALTOPTIERVOLUME24H: Double,
                @SerialName("TOTALTOPTIERVOLUME24HTO")
                val tOTALTOPTIERVOLUME24HTO: Double,
                @SerialName("TOTALVOLUME24H")
                val tOTALVOLUME24H: Double,
                @SerialName("TOTALVOLUME24HTO")
                val tOTALVOLUME24HTO: Double,
                @SerialName("TYPE")
                val tYPE: String,
                @SerialName("VOLUME24HOUR")
                val vOLUME24HOUR: Double,
                @SerialName("VOLUME24HOURTO")
                val vOLUME24HOURTO: Double,
                @SerialName("VOLUMEDAY")
                val vOLUMEDAY: Double,
                @SerialName("VOLUMEDAYTO")
                val vOLUMEDAYTO: Double,
                @SerialName("VOLUMEHOUR")
                val vOLUMEHOUR: Double,
                @SerialName("VOLUMEHOURTO")
                val vOLUMEHOURTO: Double
            )
        }
    }

    @Serializable
    data class MetaData(
        @SerialName("Count")
        val count: Int
    )

    @Serializable
    class RateLimit
}