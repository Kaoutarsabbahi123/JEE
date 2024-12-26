<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attestation</title>
<style>
    body {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f4f4f4;
    }

    .message-container {
        text-align: center;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-top: 20px;
    }

    .loading-image {
        max-width: 100px; /* ajustez la taille selon vos besoins */
    }
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
</head>
<body>

<div class="message-container">
    <img class="loading-image" src="chargement.png" alt="Chargement en cours">
    <h2>Votre demande est en cours de traitement</h2>
</div>

<script>
  
    var nom = '<%= request.getSession().getAttribute("nom") %>';
    var prenom = '<%= request.getSession().getAttribute("prenom") %>';
    var sujet = '<%= request.getSession().getAttribute("sujet") %>';
    var type = '<%= request.getSession().getAttribute("type") %>';
    var yeardebut  = '<%=  request.getSession().getAttribute("yeardebut")%>';
	var monthdebut='<%=request.getSession().getAttribute("monthdebut")%>';
	var daydebut='<%=   request.getSession().getAttribute("daydebut")%>';
	var yearfin='<%=   request.getSession().getAttribute("yearfin")%>';
	var monthfin='<%=    request.getSession().getAttribute("monthfin")%>';
	var dayfin='<%=   request.getSession().getAttribute("dayfin")%>';
	var currentYear='<%=   request.getSession().getAttribute("currentYear")%>';
	var currentMonth='<%=    request.getSession().getAttribute("currentMonth")%>';
	var currentDay='<%=   request.getSession().getAttribute("currentDay")%>';
    var nomEnc = '<%= request.getSession().getAttribute("nomEnc") %>';
    var prenomEnc = '<%= request.getSession().getAttribute("prenomEnc") %>';
    var nomDiv = '<%= request.getSession().getAttribute("nomdiv") %>';
    var entreprise = '<%= request.getSession().getAttribute("entreprise") %>';
    var ville = '<%= request.getSession().getAttribute("ville") %>';
    var cin = '<%= request.getSession().getAttribute("cin") %>';

 function genererAttestation() {
    
     const pdf = new jspdf.jsPDF();

     const contentWidth = pdf.internal.pageSize.getWidth();
     const contentHeight = pdf.internal.pageSize.getHeight();

     
     const textX = (contentWidth - 200) / 2; 
     const textY = 20;
     const fontSize = 15;
     pdf.setFont('helvetica', 'bold');
     pdf.setFontSize(12);
     pdf.text(textX, textY, entreprise);

     pdf.setFontSize(12);
     pdf.text(textX, textY + 10, `123 Rue des Roses`);
     pdf.text(textX, textY + 20, `Quartier Florissant`);
     pdf.text(textX, textY + 30, `${ville}, 25000`);

     pdf.setFontSize(fontSize);
     pdf.text(textX+70, textY + 50, `ATTESTATION DE STAGE`);
     const textWidth = pdf.getStringUnitWidth(`ATTESTATION DE STAGE`) * fontSize / pdf.internal.scaleFactor;
     const lineWidth = 0.5; 

     
     pdf.setLineWidth(lineWidth);

     
     pdf.line(textX + 70, textY + 50 + 2, textX + 70 + textWidth, textY + 50 + 2);
     pdf.setFontSize(10);
     pdf.text(textX+5, textY + 69, `Je soussigné(e) Monsieur/Madame/Mademoiselle ${nomEnc} ${prenomEnc},que M./Mme ${prenom} ${nom}, titulaire de la CIN n° ${cin}`);
     
     pdf.setFontSize(10);
     pdf.text(textX+5,textY+79,`a effectué un stage de formation au sein de notre entreprise dans la division ${nomdiv} du ${daydebut}/${monthdebut}/${yeardebut} au ${dayfin}/${monthfin}/${yearfin} .`)
     pdf.setFontSize(10);
     pdf.text(textX+5, textY + 89, `Cette attestation est délivrée à l’intéressé (e) pour servir et valoir ce que de droit.`);

     pdf.setFontSize(12);
     pdf.text(textX+130, textY + 120, `Fait à ${ville}, le ${currentDay}/${currentMonth}/${currentYear} `);

     pdf.setFontSize(12);
     pdf.text(textX+130, textY + 130, `cachet de l’entreprise`);

     
     pdf.save(`${nom}_${prenom}_attestation.pdf`);
     window.location.href = '/JEEfrontend/StagiaireServlet';
 }

 setTimeout(genererAttestation, 3000);

</script>
</body>
</html>