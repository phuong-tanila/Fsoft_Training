const header = document.querySelector(".header")
const subnav = document.querySelector('.subnav')
const sidenav = document.querySelector('.sidenav')
const bodycontent = document.querySelector('.body-content')
const box = document.querySelector('.box')
const leftside = document.querySelector('.left-side')
const body = document.querySelector('.body')
// FUNCTION
// dark theme
function darkMode() {
    const darkButton = document.querySelector('.dark-theme')
    const container = document.querySelector('.container')
    darkButton.addEventListener("click", function () {
        this.classList.toggle('on')
        if (this.classList.contains('on')) {
            header.classList.add('dark-theme-active')
            body.classList.add('dark-theme-active')
            container.classList.add('dark-theme-active')
        } else {
            header.classList.remove('dark-theme-active')
            body.classList.remove('dark-theme-active')
            container.classList.remove('dark-theme-active')
        }
    })
}

// set vị trí mặc định cho sidenav trước khi scroll
function setDefaultLocationBox() {
    const subheaderHeight = document.querySelector('.subnav').offsetHeight
    const headerHeight = document.querySelector(".header").offsetHeight
    document.querySelector('.box').style.paddingTop = `${subheaderHeight + headerHeight}px`
    if (subnav.classList.contains('sticky')) {
        box.style.paddingTop = `${subheaderHeight}px`
    } else {
        box.style.paddingTop = `${headerHeight + subheaderHeight - window.pageYOffset}px`

    }
}

function scrollSticky() {
    const headerHeight = header.offsetHeight
    if (window.pageYOffset > headerHeight) {
        subnav.classList.add("sticky")
        // box.style.paddingTop = `${subheaderHeight}px`
    } else if (window.pageYOffset <= headerHeight && window.pageYOffset >= 0) {
        subnav.classList.remove("sticky")
        // box.style.paddingTop = `${headerHeight + subheaderHeight - window.pageYOffset}px`
    }
}
var hamburger = document.querySelector('.hamburger')
function isActive() {
    if (hamburger.classList.contains('active')) {
        return true
    }
    return false
}
function renderSideNav() {
    hamburger.addEventListener('click', () => {
        hamburger.classList.toggle('active')
        if (isActive()) {
            setDefaultLocationBox()
            leftside.style.display = 'block'
        } else {
            setDefaultLocationBox()
            leftside.style.display = 'none'
        }
    })
}
function scrollHideSideNav() {
    window.addEventListener('scroll', () => {
        if (isActive()) {
            leftside.style.display = 'none'
            hamburger.classList.remove('active')
        }
    })
}
// EXECUTE
function start() {
    darkMode()
    setDefaultLocationBox()
    window.onscroll = () => {
        scrollSticky()
        setDefaultLocationBox()
    }
    scrollHideSideNav()
    renderSideNav()

}

start()

