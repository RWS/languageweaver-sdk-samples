import './App.css';
import {samplesConfig} from "./samples-utils";
import {useState} from "react";

function App() {
    const [cloudClientId, setCloudClientId] = useState("");
    const [cloudClientSecret, setCloudClientSecret] = useState("");
    const [edgeClientId, setEdgeClientId] = useState("");

    return (
        <div className="app flex-container">
            {constructApiCredentialsArea()}
            {constructSampleCategories()}
        </div>
    );

    function constructApiCredentialsArea() {
        return <div className="api-credentials flex-container">
            <span className="api-credentials-title">Set API Credentials:</span>
            <span>Cloud</span>
            <div className="api-credentials-inputs">
                {constructInput("Client id:", value => setCloudClientId(value))}
                {constructInput("Client secret:", value => setCloudClientSecret(value))}
            </div>
            <span>Edge</span>
            <div className="api-credentials-inputs">
                {constructInput("Client id:", value => setEdgeClientId(value))}
            </div>
        </div>
    }

    function constructInput(label, onChange) {
        return <div className="api-credentials-input-wrapper">
            <label>{label}</label>
            <input className="api-credentials-input" type="text" onChange={event => onChange(event.target.value)}/>
        </div>;
    }

    function constructSampleCategories() {
        return <div className="sample-categories flex-container">
            <span className="sample-categories-title">Choose sample to run:</span>
            {samplesConfig.map(category => constructSampleCategory(category))}
        </div>;
    }

    function constructSampleCategory(category) {
        return <div className="sample-category flex-container" key={category.id}>
            <span className="sample-category-title">{category.title}</span>
            <div className="sample-category-items">
                {category.items.map(item => constructSampleCategoryItem(item))}
            </div>
        </div>;
    }

    function constructSampleCategoryItem(item) {
        return <div className="sample-category-item flex-container" key={item.id}>
            <div className="sample-category-item-title" onClick={() => handleClick(item)}>
                {item.title}
            </div>
        </div>
    }

    function handleClick(item) {
        return item.id.includes("edge") ? item.onClick(edgeClientId) : item.onClick(cloudClientId, cloudClientSecret)
    }
}

export default App;
