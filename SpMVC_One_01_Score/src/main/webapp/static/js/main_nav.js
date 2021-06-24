document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main_nav");

  nav.addEventListener("click", (e) => {
    let tagName = e.target.tagName;

    if (tagName === "LI") {
      let menuText = e.target.textContent;

      let urlPath = `${rootPath}`;

      if (menuText === "HOME") {
        urlPath += "/";
      } else if (menuText === "학생정보") {
        // location.href = "{$rootPath}/books"와 같은의미
        urlPath += "/student";
      } else if (menuText === "성적알림표") {
        urlPath += "/scores";
      }
      location.href = urlPath;
    }
  });
});
