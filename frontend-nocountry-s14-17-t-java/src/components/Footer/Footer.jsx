import { Link } from "react-router-dom";
import Logo from "../Logo/Logo";
import { FaGithub } from "react-icons/fa6";

const Footer = () => {
  return (
    <footer className="fixed bottom-0 mt-6 daisy-footer daisy-footer-center p-10 bg-black text-primary-content">
      <Link to="/"><Logo /></Link>
      <aside>
        <Link to="https://github.com/No-Country/s14-17-t-java">
          <FaGithub  className="w-[40px] h-[40px]"/>
        </Link>
      </aside>

      <div className=" w-full flex justify-between items-center gap-4">
        <p className="font-bold">
          Proyecto realizado <br />
          Por el equipo S14-17-T-JAVA
        </p>
        <p>Copyright © 2024 - Todos los derechos reservados</p>
      </div>
    </footer>
  );
};

export default Footer;
