<%
session.setAttribute("userid", null);
session.setAttribute("b_userid", null);
session.invalidate();
response.sendRedirect("index.html");
%>